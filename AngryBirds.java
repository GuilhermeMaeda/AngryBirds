package angryBrirds;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AngryBirds {
	static JFrame tela; // DECLARA A VARIAVEL TELA
    static JLabel fundo = new JLabel (new ImageIcon("Img\\fundo2.png")); //CRIA A IMAGEM DE PLANO DE FUNDO
    static JLabel red = new JLabel (new ImageIcon("Img\\red.png")); // CRIA A IMAGEM DO PASSARINHO RED
    static JLabel estilingue = new JLabel (new ImageIcon("Img\\estilingue3.png"));; // CRIA A IMAGEM DO ESTILINGUE
    static JMenuBar janelinha; // DECLARA A VARIAVEL JANELINHA
	static JMenu menu = new JMenu("MENU"); // DECLARA A VARIAVEL MENU
	static JMenuItem informacao = new JMenuItem("INFORMAÇÕES"); // DECLARA A VARIAVEL INFORMACAO
	static JMenuItem ajuda = new JMenuItem("AJUDA"); // DECLARA A VARIAVEL AJUDA
	static JMenuItem sair = new JMenuItem("SAIR"); // DECLARA A VARIAVEL SAIR
    static JProgressBar barrinha_de_forca; // DECLARA A VARIAVEL BARRINHA	 
    static int forca; // DECLARA A VARIAVEL FORCA
    static boolean movimento = false; // INICIA O MOVIMENTO IGUAL A FALSO
    
  
    	   	    
	public static void main(String[] args){ //SERVE COMO UM MENU QUE ARMAZENA TODAS AS ACOES DO JOGO
		
		tela = new JFrame(); // CRIA A TELA
		barrinha_de_forca = new JProgressBar(); //CRIA A BARRINHA DE FORCA
		janelinha = new JMenuBar(); // CRIA A JANELINHA 
		Tela();	// // ACAO QUE FAZ TODA A TELA
		Menu(); // ACAO QUE O MENU FAZ
		Barrinha_Forca(); // ACAO QUE FAZ A BARRINHA DE FORCA
		Movimento_Barrinha_Forca(); // MOVIMENTO QUE A BARRINHA DE FORCA FAZ
		Movimento_Personagem(); // ACAO QUE FAZ O MOVIMENTO DO PERSONAGEM FORMANDO A PARABOLA
		
	}		
	static void Tela() { 
			
		tela.setTitle("ANGRY BIRDS"); // DEFINE O NOME DA TELA
		tela.setSize(1600, 900); // DEFINE O TAMANHO DA TELA
		tela.setLocation(0, 0); // DEFINE A POSICAO DA TELA
		tela.setResizable(false); // DEFINE SE A TELA AUMENTA E DIMINUI
		tela.setVisible(true); // TORNA A TELA VISIVEL AO USUARIO	    
		tela.add(red).setBounds(50, 550, 150, 150); //ADICIONA O PASSARINHO RED NA TELA
		tela.add(estilingue).setBounds(50,580,150,150); //ADICIONA O ESTILINGUE NA TELA
        tela.add(barrinha_de_forca).setBounds(35,30,1300,50); //ADICIONA A BARRINHA DE FORÇA NA TELA
        tela.add(fundo).setBounds(0, 0, 1200, 900); //ADICIONA O PLANO DE FUNDO NA TELA
        
        
	}
	
	static void Menu () {
		
		tela.setJMenuBar(janelinha); // TELA ADICIONA A JANELINHA
		janelinha.add(menu); // JANELINHA ADICIONA O MENU
	    menu.add(informacao); // MENU ADICIONA A INFORMACAO
		menu.add(ajuda); // MENU ADICIONA A AJUDA
		menu.add(sair); // MENU ADICIONA O SAIR
		informacao.addActionListener(new ActionListener(){ // CONDICAO DA OPCAO INFORMACAO
			public  void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog
				(null, "TELA INSPIRADA NO JOGO ANGRY BIRDS:"
						+ " DESENVOLVIDA POR AMANDA, EDWIN E GUILHERME MAEDA"); // MOSTRA A MENSAGEM AO USUARIO
			}
		});
		ajuda.addActionListener(new ActionListener(){ // CONDICAO DA OPCAO AJUDA
			public  void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog
				(null, "TECLE ENTER PARA LANÇAR O PASSARINHO RED"); // MOSTRA A MENSAGEM AO USUARIO
			}
		});
		sair.addActionListener(new ActionListener(){ // CONDICAO DA OPCAO SAIR
			public  void actionPerformed(ActionEvent e){
				System.exit(0); // FECHA A TELA
			}
		});
	}
	static void Barrinha_Forca(){ 
	
	
		barrinha_de_forca.setMinimum(0); //O MINIMO QUE A BARRINHA PODE ATINGIR E 0
		barrinha_de_forca.setMaximum(100);// O MAXIMO QUE A BARRINHA PODE ATINGIR E 100
		barrinha_de_forca.setBackground(Color.BLACK);// ADICIONA A COR DO FUNDO DA BARRINHA DE FORCA
		barrinha_de_forca.setForeground(Color.RED); // ADICIONA A COR DA BARRINHA DE FORCA
		barrinha_de_forca.setVisible(true); // TORNA A BARRINHA DE FORCA VISIVEL AO USUARIO
		
	}
	static void Movimento_Barrinha_Forca(){ 
		for(int numero = 0; numero <= 100; numero++){ // VARIAVEL NUMERO SE INICIA NO 0, QUE SOMA ATÉ CHEGAR NO 100
			barrinha_de_forca.setValue(numero);
            try{
				Thread.sleep(50); // VELOCIDADE QUE A BARRINHA FAZ AO IR DE 0 ATE 100
			}catch (InterruptedException e1) {
				e1.printStackTrace();
			}
            Teclado(); // ACAO DO TECLADO SOBRE O MOVIMENTO DA BARRINHA DE FORCA 
            if(movimento){ // FAZ O MOVIMENTO DO PASSARINHO
            	break; // PAUSA DA BARRINHA DE FORCA
            }
            if(numero == 100){ // VARIAVEL NUMERO ATINGIU O 100
            	for(numero = 100; numero >= 0; numero--){ // VARIAVEL NUMERO SE INICIA NO 100, QUE SUBTRAI ATÉ CHEGAR NO 0
            		barrinha_de_forca.setValue(numero);
    	            try{
    					Thread.sleep(50); // VELOVIDADE QUE A BARRINHA FAZ AO IR DE 100 ATE 0
    				}catch (InterruptedException e1) {
    					e1.printStackTrace();
    				}
    	            Teclado(); // ACAO DO TECLADO SOBRE O MOVIMENTO DA BARRINHA DE FORCA
    	            if(movimento){ // FAZ O MOVIMENTO DO PASSARINHO
    	            	break; // PAUSA DA BARRINHA DE FORCA
    	            }
            	}
            }
        }
	}
	
	static void Movimento_Personagem(){ 
        
        
        double x = 0; // CRIA A VARIVEL X
        double y = 0; // CRIA A VARIAVEL Y
        double t = 1; // CRIA A VARIAVEL T
        double g = 9.8; // CRIA A VARIAVEL GRAVIDADE QUE É A CONDICAO QUE PERMITE QUE O RED SUBA E DEPOIS CAIA, SEM ELA ELE APENAS SOBE
        double f = forca; // CRIA A VARIAVEL F QUE É IGUAL A FORCA
        double angulo = 60 *(Math.PI /180); // CRIA A VARIVEL ANGULO QUE É IGUAL A 60, ANGULO QUE A PARABOLA FAZ 
        double cosseno = (Math.cos(angulo));  // CRIA A VARIAVEL COSSENO DO ANGULO DE 60 GRAUS
        double seno = (Math.sin(angulo)); // CRIA A VARIAVEL SENO DO ANGULO DE 60 GRAUS
        int x1 = 150; // CIRA A VARIAVEL X1 QUE É A POSICAO X1 DO PASSARINHO NA TELA
        int y1 = 50; // CRIA A VARIAVEL Y1 QUE É A POSICAO Y1 DO PASSARINHO NA TELA
        
        while(y >= 0 && x <= 1600){ // TAMANHO MINIMO E MAXIMO QUE O PASSARINHO RED PODE ATINGIR
        	red.setLocation((int)x,(((int)y - 620)*(-1))); // 
               x = (x1 + (f * cosseno * t)); // X = (150 + (FORCA * COSSENO * 1))
               y = (y1 + (f * seno * t)-((g *(t * t)) /2)); // Y = (50 + (FORCA * SENO * 1) - ((9,8 * (1 * 1)) / 2 )) 
               t = t + 0.01; // T = 1 + 0,01 --> TEMPO QUE ELE DEMORA PARA CHEGAR AO CHÃO
               if (y <= 50.0 && t > 0){ // SE ( Y <= 50.0 E T > 0 )
                      f = f *0.6; // FORCA = FORCA * 0,6
                      x1 = (int) x; // X1 = X
                      y1 = 1; // Y1 = 1
                      y = 0; // Y = 0
                      t = 0; // TEMPO = 0
               }
              
               int v = Forca_Barrinha(); // VELOCIDADE QUE O PASSARINHO ATINGI É IGUAL A 1
               try {
                      Thread.sleep(v);
               } catch (InterruptedException e1) {
                      
               }                         
        }                                      
 }
	
	static void Teclado(){ // ACAO QUE FAZ O PASSARINHO SE MOVIMENTAR QUANDO O USUARIO APERTA O ENTER
		tela.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){ // CODIGO DA TECLA ENTER			
					movimento = true; // SE A PESSOA APERTA O ENTER, ENTÃO O MOVIMENTO TORNA-SE VERDADEIRO
					forca = barrinha_de_forca.getValue(); // ENTÃO A FORCA OBTIDA PELA BARRINHA DE FORCA É IGUAL A 1							
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){ // CODIGO DA TECLA ENTER			
					movimento = true; // SE A PESSOA APERTA O ENTER, ENTÃO O MOVIMENTO TORNA-SE VERDADEIRO
					forca = barrinha_de_forca.getValue();	 // ENTÃO A FORCA OBTIDA PELA BARRINHA DE FORCA É IGUAL A 1											
				}					
			}				
		});	
		tela.getKeyListeners(); // A TELA APLICA O MOVIMENTO QUANDO O ENTER É PRECIONADO PELO USUARIO
	}
	static int Forca_Barrinha(){
		int forrca = 0; // A FORÇA QUE SE INICIA É IGUAL A ZERO
		if(forca >= 0 && forca <= 100){ 
			forrca = 1; //A FORÇA EM QUE O PASSARINHO RED É LANÇADO E IGUAL A 1, QUANTO MAIS ALTO O VALOR DA FORÇA MAIS LENTO ELE FICA
		}
		
		return forrca; // RETORNA A FORCA = 1
	
	}
	
}
