package controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import processador.pipeline.BlocoControle;
import processador.pipeline.Memoria;
import processador.pipeline.Registradores;
import javafx.scene.control.TextArea;
import processador.pipeline.ULA;
import processador.pipeline.Decoder;

public class pipelineController {
	
	
	 Registradores getRegistradores ;
	
	 Memoria getMemoria;
   
	@FXML
    private ListView<String> l1,l2,l3;

    @FXML
    void carrega(ActionEvent event) {
    	  //Leitura do arquivo
    	try {
			FileChooser fc = new FileChooser();
			fc.setTitle("Escolha um arquivo mips");
			fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("MIPS", "*.mips*"));
			File file = fc.showOpenDialog(null);
			 FileReader arq = new FileReader(file.getAbsolutePath());
	         BufferedReader lerArq = new BufferedReader(arq);
	         if(file!=null) {
	        	 while(lerArq.ready()) {
	        	 String linha = lerArq.readLine();
	        	l1.getItems().addAll(linha);
	        	 }
	        	 }
    	}catch(Exception e) {
			MSA("Arquivo Invalido");
		}
    	}

    @FXML
    void executa(ActionEvent event) {
    	try {
    	 l2.getItems().addAll(Registradores.getInstance().toString());
    	 l3.getItems().addAll(Memoria.getInstance().toString());
    	}catch(Exception e) {
    		MSA("Escolha um arquivo para executar");
    	}
    }
    
    @FXML
    void limpa(ActionEvent event) {
    	l1.getItems().clear();
    	l2.getItems().clear();
    	l3.getItems().clear();

    }
    
    public static void MSA (String msg){
		Alert alert = new Alert (AlertType.WARNING);
		alert.setTitle("Atenção");
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.showAndWait();
		
		}
    public static int Mux(int ent0, int ent1, int op){
        if(op == 0){return ent0;}
        if(op == 1){return ent1;}
        MSA("Erro na operações de controle do Mux!!!");
        return -1;
    }

    public static List<String> getCodigo(String linhas)// Cria o vetor de String aonde fica o codigo inteiro do programa
    {
        int comeco = 0;
        int fim = linhas.length();
        Boolean aux = false;

        for(int  i = 0; i<linhas.length()-6; i++){
            if(linhas.substring(i, i+5).equals("main\n") && !aux){
                comeco = i+6;
                aux = true;
            }
            if(aux && linhas.substring(i, i+5).equals(".data")){
                fim = i-1;
                break;
            }

        }

        String [] code = linhas.substring(comeco, fim).trim().split("\n");
        String ajuste;
        List<String> listCode = new ArrayList<String>(Arrays.asList(code));
        ArrayList<String> recebe = new ArrayList();
        // Para retirar os vetores em branco
        while(listCode.contains("")){
            listCode.remove("");
        }



        // Esse for ao colocar a label na mesma linha do codigo
        for(int i = 0; i<listCode.size();i++){
            if(listCode.get(i).charAt(listCode.get(i).length()-1) == ':'){
                ajuste = listCode.remove(i).trim().replace(":", "") + " " +listCode.remove(i).trim();
                listCode.add(i, ajuste);
            }
            listCode.add(i, listCode.remove(i).trim());
        }

        return listCode;
    }
    
    public void Ex () {
    	 List<String> code = new ArrayList<String>();
    	 ArrayList<String> recebe = new ArrayList();
    	 
         String linhas = "";
         Registradores blreg = Registradores.getInstance();
         BlocoControle blcontrol = BlocoControle.getInstance();
         Memoria mem = Memoria.getInstance();
         ULA ulaPrincipal = new ULA();
         ULA fullAdder = new ULA();

         code = getCodigo(linhas);
         Decoder dec = new Decoder(code);
         
         String [] memoriaIntrucao = dec.decoder(); // Isso são todas as instruçoes do codigo em binario
         String [] instHex = dec.decoderHex(); // Isso são todas as instruçoes do codigo em hexa
        
         int pc = 1280;
         while(true){
         
             int pcReal = (pc-1280)/4;

             if(pcReal == code.size()){
                 System.exit(0);
             }
             for(int i = 0;i<code.size();i++){
                 System.out.print(instHex[i]+"   ");
                 System.out.print("   "+code.get(i));
                 recebe.add(code.get(i));
                 if(i == pcReal){
                     System.out.print("  <--\n");
                 }else {System.out.print("\n");}
             }
             int writeR = Integer.parseInt(memoriaIntrucao[pcReal].substring(16,21),2); // rd
             int regUm = Integer.parseInt(memoriaIntrucao[pcReal].substring(6,11),2); // rs
             int regDois = Integer.parseInt(memoriaIntrucao[pcReal].substring(11,16),2); // rt
             int immediate =  Integer.parseInt(memoriaIntrucao[pcReal].substring(16,32),2);
             int shiftNumber = Integer.parseInt(memoriaIntrucao[pcReal].substring(21,26),2);
             int jumpNumber = Integer.parseInt(memoriaIntrucao[pcReal].substring(6,32),2);

             //Parte do bloco de controle
             blcontrol.controlByOpCode(memoriaIntrucao[pcReal].substring(0,6));

             int saidaMux = BlocoControle.writeRegMux(regDois, writeR, blcontrol.regDst);

             //AluContro e MUX para a ULA
             int aluControl = blcontrol.ulaControl(blcontrol.aluOp0, blcontrol.aluOp1, blcontrol.lui, memoriaIntrucao[pcReal].substring(26,32));

             //Parte da busca no bloco de registradores e MUX para saber se Ã© shift
             int reg2Toreg2 = Mux(regUm, regDois, blcontrol.reg2TOreg1);

             blreg.busca(reg2Toreg2, regDois, saidaMux, blcontrol.regWrite);
             saidaMux = BlocoControle.aluOp2Mux(blreg.saida2(), immediate, blcontrol.aluSrc);
             saidaMux = BlocoControle.shiftControlMux(saidaMux, shiftNumber , blcontrol.shamt);
             
             //pc++
             pc = fullAdder.saida(pc, 4, 2);

             //prepara numero pro jump
             jumpNumber = jumpNumber*4;

             int muxLUI = Mux(blreg.saida(), immediate, blcontrol.lui);
             //Calculo da ULA principal
             int saidaULA = ulaPrincipal.saida(muxLUI, saidaMux, aluControl);

             //prepara numero pro beq
             int pcBEQ = fullAdder.saida((immediate*4), pc, 2);
             int muxBranch = Mux(pc, pcBEQ, (blcontrol.branch & ulaPrincipal.Zero));

             //Arruma Pc se for branch ou jump
             pc = Mux(muxBranch, jumpNumber, blcontrol.jump);

             int saidaMemoria = mem.entradas(saidaULA, blreg.saida2(), blcontrol.memRead, blcontrol.memWrite);
             int memToReg = BlocoControle.memToRegMux(saidaULA, saidaMemoria, blcontrol.memToReg);
             blreg.writeBack(memToReg);
             }

        
    }
}
