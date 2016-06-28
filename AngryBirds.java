package angryBrirds;
package angryBrirds;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class AngryBirds2 {

	//VARIAVEIS QUE SERÃƒO UTILIZADAS NO JOGO
	static JFrame tela = new JFrame();
	static JFrame telainicial = new JFrame("ANGRY BIRDS");
	static JFrame telamenu = new JFrame("Como jogar");
	static JFrame telamenu1 = new JFrame("Força de lançamento");
	static JFrame telamenu2 = new JFrame("Ângulo de lançamento");

	static ImageIcon iconEstilingue3 = new ImageIcon("imagem\\estilingue3.png");
	static ImageIcon iconEstilingue1 = new ImageIcon("imagem\\estilingue1.png");

	static int posEstiligueeX = 100;
	static int posEstiligueeY = 400;

	static JLabel fundo = new JLabel(new ImageIcon("Img\\fundo.jpg"));
	static JLabel red = new JLabel(new ImageIcon("Img\\red.gif"));
	static JLabel red1 = new JLabel(new ImageIcon("Img\\red1.gif"));
	static JLabel estilingue = new JLabel(iconEstilingue1);
	static JLabel jlplay = new JLabel(new ImageIcon("Img\\play.png"));
	static JLabel bird = new JLabel(new ImageIcon("Img\\bird.jpg"));
	static JLabel tutorial1 = new JLabel(new ImageIcon("Img\\tutorial1.png"));
	static JLabel tutorial2 = new JLabel(new ImageIcon("Img\\tutorial2.png"));
	static JLabel tutorial3 = new JLabel(new ImageIcon("Img\\tutorial3.png"));
	static JLabel pig = new JLabel(new ImageIcon("Img\\pig.png"));
	static JLabel ovo = new JLabel(new ImageIcon("Img\\ovos.png"));

	static JLabel velocimetro = new JLabel("0,0 m/s");
	static JLabel velocidade = new JLabel("V = ");
	static JLabel velocidade1 = wordLabel("0 m/s");
	static JLabel velocidade2 = wordLabel("100 m/s");
	static JLabel angulo1 = wordLabel("0Â°");
	static JLabel angulo2 = wordLabel("90Â°");

	static int minimum = 0;
	static int maximum = 100;

	static JProgressBar barraF = new JProgressBar(JProgressBar.VERTICAL, minimum, maximum);
	static JProgressBar barraA = new JProgressBar();

	static JMenuBar janelinha = new JMenuBar();

	static JMenu menu = new JMenu("MENU");

	static JMenuItem informacao = new JMenuItem("Iinformações");
	static JMenuItem ajuda = new JMenuItem("AJUDA");
	static JMenuItem sair = new JMenuItem("SAIR");
	static JMenuItem replay = new JMenuItem("Jogar novamente");
	
	static JButton proximo = new JButton("Próximo");
	static JButton seguinte = new JButton("Próximo");
	static JButton ok = new JButton("Ok");
	static JButton play = new JButton("Play");
	static JButton ajuda1 = new JButton("Sobre");
	static JButton sair1 = new JButton("Sair");
	static JButton jogar = new JButton(new ImageIcon("Img\\play.png"));
	static JButton tutorial = new JButton("Tutorial");
	static JButton voltar = new JButton("Voltar");
	static Font fonte = new Font("ALGERIAN", Font.PLAIN, 24);

	static int forca;
	static int angulo;
	static int enter = 0;

	static boolean Forcca = false;
	static boolean Angullo = false;

	//CHAMANDO AS FUNCOES DENTRO DO MAIN
	public static void main(String[] args) {
		Tela_Inicial();
		menu();
		Botoes();
		Barra();
		movimento_BarraF();
		movimento_Estilingue();

		if (Forcca ) {
			movimento_BarraA();
			if (Angullo) {
				movimento_Personagem();
			}
		}

	}
	static void Tela_Inicial() {
		telainicial.setTitle("BEM VINDO AO ANGRY BIRDS");
		telainicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telainicial.setSize(1300, 700);
		telainicial.setLocation(0, 0);
		telainicial.setResizable(false);
		telainicial.setLayout(null);
		telainicial.setVisible(true);

		telainicial.add(ajuda1).setBounds(25, 30, 150, 50);
		ajuda1.setForeground(Color.BLUE);
		ajuda1.setFont(fonte);

		telainicial.add(sair1).setBounds(25, 160, 150, 50);
		sair1.setForeground(Color.BLUE);
		sair1.setFont(fonte);
		
		telainicial.add(tutorial).setBounds(25, 95, 150, 50);
		tutorial.setForeground(Color.BLUE);
		tutorial.setFont(fonte);
		
		telainicial.add(jogar).setBounds(550, 550, 150, 100);
		telainicial.add(jlplay).setBounds(550, 550, 150, 100);
		jogar.setForeground(Color.BLUE);
		jogar.setFont(fonte);
		telainicial.add(bird).setBounds(0, 0, 1300, 700);
	}

	//TELA DO JOGO
	static void Tela() {

		tela.setTitle("ANGRY BIRDS");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(1365, 700);
		tela.setLocation(0, 0);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setVisible(true);

		Componentes_Tela();

	}

	//COMPONENTES DA TELA, ESTA TELA CONTEM TODOS OS ITENS QUE APARECERÃƒO PARA O USUARIO
	static void Componentes_Tela() {

		red.setVisible(true);
		red1.setVisible(false);
		tela.add(velocidade).setBounds(150, 100, 260, 30);
		tela.add(velocimetro).setBounds(180, 100, 260, 30);
		tela.add(red).setBounds(50, 530, 50, 55);
		tela.add(red1).setBounds(120, 400, 100, 50);
		tela.add(pig).setBounds(800, 500, 200, 100);
		tela.add(ovo).setBounds(950, 510, 100, 100);
		tela.add(barraF).setBounds(50, 30, 30, 200);
		tela.add(barraA).setBounds(100, 30, 200, 30);
		tela.add(velocidade1).setBounds(10, 200, 50, 50);
		tela.add(velocidade2).setBounds(0, 15, 50, 50);
		tela.add(angulo1).setBounds(100, 50, 50, 50);
		tela.add(angulo2).setBounds(280, 50, 50, 50);
		tela.add(estilingue).setBounds(posEstiligueeX, posEstiligueeY, 200, 200);
		tela.add(fundo).setBounds(0, 0, 1365, 650);
	}
		static void menu(){
		//MENU DE INFORMACAO
		tela.setJMenuBar(janelinha);
		janelinha.add(menu);
		menu.add(informacao);
		menu.add(ajuda);
		menu.add(sair);
		menu.add(replay);
		informacao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"TELA INSPIRADA NO JOGO ANGRY BIRDS:" + " DESENVOLVIDA POR AMANDA, EDWIN E GUILHERME MAEDA");
			}
		});
		ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TECLE ENTER PARA LANÃ‡AR O PASSARINHO RED");
			}
		});
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		replay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int reiniciar = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?");
				if(reiniciar == JOptionPane.YES_OPTION){
				    tela.dispose();
				    Tela_Inicial();
				    menu();
					Botoes();
					Barra();
					movimento_BarraF();
					movimento_Estilingue();

					if (Forcca ) {
						movimento_BarraA();
						if (Angullo) {
							movimento_Personagem();
						}
					}
				   }
			}
		});
		}

	//BARRA DE FORCA E BARRA DE ANGULO
	static void Barra() {

		barraF.setBackground(Color.BLACK);
		barraF.setForeground(Color.yellow);
		barraF.setVisible(true);

		barraA.setMinimum(0);
		barraA.setMaximum(90);
		barraA.setBackground(Color.BLACK);
		barraA.setForeground(Color.yellow);
		barraA.setVisible(true);

	}

	//MOVIMENTO QUE A BARRA DE FORCA FAZ DE 0 ATÃ‰ 100
	static void movimento_BarraF() {
		for (int i = 0; i <= 100; i++) {
			barraF.setValue(i);
			try {
				Thread.sleep(15);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Teclado();
			if (Forcca ) {
				enter++;
				break;
			}
			if (i == 100) {
				for (i = 100; i >= 0; i--) {
					barraF.setValue(i);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Teclado();
					if (Forcca ) {
						enter++;
						break;
					}
				}
			}
		}
	}

	//MOVIMENTO QUE A BARRA DE ANGULO FAZ DE 0 ATÃ‰ 90 GRAUS
	static void movimento_BarraA() {
		for (int numero = 0; numero <= 90; numero++) {
			barraA.setValue(numero);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Teclado();
			if (Angullo) {
				break;
			}
			if (numero == 90) {
				for (numero = 90; numero >= 0; numero--) {
					barraA.setValue(numero);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e1) {

						e1.printStackTrace();
					}
					Teclado();
					if (Angullo) {
						break;
					}
				}
			}
		}
	}

	//MOVIMENTO QUE O PERSONAGEM IRÃ� FAZER
	static void movimento_Personagem() {

		double x = 0;
		double y = 0;
		double t = 1;
		double g = 9.8;
		double f = forca;
		double angulo1 = angulo * (Math.PI / 180);
		double cosseno = (Math.cos(angulo1));
		double seno = (Math.sin(angulo1));
		boolean iniciar = true;
		int x1 = 100;
		int y1 = 50;

		red.setVisible(false);
		red1.setVisible(true);
		while (iniciar == true) {

			x = (x1 + (f * cosseno * t));
			y = (y1 + (f * seno * t) - ((g * (t * t)) / 2));
			t = t + 0.01;

			red1.setLocation((int) x, (((int) y - 580) * (-1)));

			 if ((((int) x >= 750 && (int) x <= 800) && (int) y <= 600)) {
				pig.setLocation(800, 500);
				red1.setLocation(1200, 530);
				ovo.setLocation(1250,500);
				JOptionPane.showMessageDialog(null, "VOCÃŠ ATINGIU OS PORCOS E RECUPEROU OS OVOS!!!");
		
				Angullo = false;
				Forcca = false;
				enter = 0;
				break;
			} 
					double vel = calculo_Velocimetro(cosseno, seno, t, f);

					DecimalFormat dc = new DecimalFormat("#0.00");
					String velocidade123 = "m/s";
					velocimetro.setText(dc.format(vel) + velocidade123);
					forca = (int) vel;
			
	
			if ((int) y <= 42.0 && t > 0) {
				f = f * 0.6;
				x1 = (int) x;
				y1 = 42;
				y = 42;
				t = 1;

			}

			int velocidade = Forca_Barra();
			try {
				Thread.sleep(velocidade);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

		if (Forcca) {
			movimento_BarraA();
			if (Angullo) {
				movimento_Personagem();
			}
		}

	}
	
	//CALCULO DA VELOCIDADE X
	static double velocidadeX(double v, double cos) {
		double velocidade = v * cos;
		return velocidade;
	}

	//CALCULO DA VELOCIDADE Y
	static double velocidadeY(double v, double sen, double t) {
		double velocidade = (v * sen) - (9.8 * t);

		return velocidade;
	}

	//CALCULO DO VELOCIMETRO
	static double calculo_Velocimetro(double c, double s, double t, double v0) {
		double vX= velocidadeX(v0, c);
		double vY = velocidadeY(v0, s, t);
		double vel = Math.sqrt((vX * vX) + (vY * vY));
		return vel;
	}
	
	//MOVIMENTO DA TROCA DE ESTILINGUE
	static void movimento_Estilingue() {
		tela.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
				estilingue.setIcon(iconEstilingue1);
			}

			public void keyPressed(KeyEvent e) {
				estilingue.setIcon(iconEstilingue3);
				if (e.getKeyCode() == 38) {
					posEstiligueeY -= 0;
				}
				if (e.getKeyCode() == 40) {
					posEstiligueeY += 0;
				}
				if (e.getKeyCode() == 37) {
					posEstiligueeX -= 0;
				}
				if (e.getKeyCode() == 39) {
					posEstiligueeX += 0;
				}
				estilingue.setBounds(posEstiligueeX, posEstiligueeY, 200, 200);
			}
		});
	}

	//FUNCAO DO BOTAO ENTER QUANDO Ã‰ PRECIONADO
	static void Teclado() {
		tela.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!Forcca) {
						Forcca = true;
						forca = barraF.getValue();
					} else if (enter > 0) {
						Angullo = true;
						int a = barraA.getValue();
						angulo = (int) (a * 100) / 90;
						if (angulo > 90) {
							angulo = 90;
						}
					}

				}
			}
		});
	}

	//FORCA QUE O PASSARINHO ATINGE
	static int Forca_Barra() {
		int forrca = 0;
		if (forca >= 0 && forca <= 100) {
			forrca = 1;

		}

		return forrca;

	}

	public static JLabel wordLabel(String numero) {
		JLabel wLabel = new JLabel(numero);

		return wLabel;
	}
	static void Botoes() {
		ajuda1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,"Game AngryBirds versão 1.0\n"
						+ "Copyright © 2016 by AEG Company. Todos os direitos reservados");

			}
		});
		
		sair1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				

			}
		});
		jogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telainicial.setVisible(false);
				Tela();
				

			}
		});
		tutorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	             tutorial_game();
			}
		});
		voltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telamenu.dispose();
				Tela_Inicial();
				

			}
		});
	}
	
	static void tutorial_game(){
		telamenu.setTitle("Como jogar");
		telamenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telamenu.setSize(1365, 700);
		telamenu.setBackground(Color.red);
		telamenu.setLocation(0, 0);
		telamenu.setResizable(false);
		telamenu.setLayout(new BorderLayout());
		telamenu.setVisible(true);
		telamenu.add(tutorial1, BorderLayout.CENTER);
		telamenu.add(proximo,BorderLayout.SOUTH);
		JOptionPane.showMessageDialog(null, "Bem vindo ao tutorial do jogo\n"
				+ "Esta é a tela principal\n"
				+ "Você deve acertar o(s) porco(s) para resgatar os ovos");
		proximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telamenu.dispose();
				tutorial_game1();
				}
		});
}
	static void tutorial_game1(){
		telamenu1.setTitle("Como jogar");
		telamenu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telamenu1.setSize(1365, 700);
		telamenu1.setBackground(Color.red);
		telamenu1.setLocation(0, 0);
		telamenu1.setResizable(false);
		telamenu1.setLayout(new BorderLayout());
		telamenu1.setVisible(true);
		telamenu1.add(tutorial2, BorderLayout.CENTER);
		telamenu1.add(seguinte, BorderLayout.SOUTH);
		seguinte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telamenu1.dispose();
				tutorial_game2();
				}
		});
	}
	static void tutorial_game2(){
		telamenu2.setTitle("Como jogar");
		telamenu2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telamenu2.setSize(1365, 700);
		telamenu2.setBackground(Color.red);
		telamenu2.setLocation(0, 0);
		telamenu2.setResizable(false);
		telamenu2.setLayout(new BorderLayout());
		telamenu2.setVisible(true);
		telamenu2.add(tutorial3, BorderLayout.CENTER);
		telamenu2.add(ok, BorderLayout.SOUTH);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "O tutorial termina aqui\n"
						+ "Após isso, o pássaro será lançado de acordo com a força e o ângulo desejado\n"
						+ "Boa sorte e divirta-se!");
				telamenu2.dispose();
				}
		});
	}

}

