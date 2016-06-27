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

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AngryBirds {

	static JFrame tela = new JFrame();
	static JFrame telainicial = new JFrame("ANGRY BIRDS");
	static JFrame telamenu = new JFrame("MENU");
	static JFrame telajogo = new JFrame("ANGRY BIRDS GAMING");

	static ImageIcon iconEstilingue3 = new ImageIcon("Img\\estilingue3.png");
	static ImageIcon iconEstilingue1 = new ImageIcon("Img\\estilingue1.png");

	static JLabel fundo = new JLabel(new ImageIcon("Img\\fundo.jpg"));
	static JLabel red = new JLabel(new ImageIcon("Img\\red.gif"));
	static JLabel red1 = new JLabel(new ImageIcon("Img\\red1.gif"));
	static JLabel estilingue = new JLabel(iconEstilingue1);
	static JLabel iconbird = new JLabel(new ImageIcon("Img\\bird.png"));
	static JLabel bird = new JLabel(new ImageIcon("Img\\bird.jpg"));
	static JLabel tutorial123 = new JLabel(new ImageIcon("Img\\1.png"));
	static JLabel pig = new JLabel(new ImageIcon("Img\\pig.png"));
	static JLabel pig1 = new JLabel(new ImageIcon("Img\\Pig1.png"));
	static JLabel pig2 = new JLabel(new ImageIcon("Img\\pig2.png"));

	static JButton reiniciar = new JButton(new ImageIcon("imagem\\reiniciar.png"));
	static JButton play = new JButton("Play");
	static JButton ajuda1 = new JButton("Ajuda");
	static JButton sair1 = new JButton("Sair");
	static JButton jogar = new JButton(new ImageIcon("imagem\\play.jpg"));
	static JButton tutorial = new JButton("Tutorial");
	static JButton voltar = new JButton("Voltar");

	static Font fonte = new Font("ALGERIAN", Font.PLAIN, 24);

	static JMenuBar janelinha = new JMenuBar();

	static JMenu menu = new JMenu("MENU");

	static JMenuItem informacao = new JMenuItem("INFORMAÇÕES");
	static JMenuItem ajuda = new JMenuItem("AJUDA");
	static JMenuItem sair = new JMenuItem("SAIR");

	static int minimum = 0;
	static int maximum = 100;
	static JProgressBar barrinha_de_forca = new JProgressBar(JProgressBar.VERTICAL, minimum, maximum);

	static int forca;
	static boolean movimento = false;

	static int posEstiligueeX = 100;
	static int posEstiligueeY = 400;

	public static void main(String[] args) {

		Tela_Inicial();
		Botoes();
		addMovimento();
		Barrinha_Forca();
		Movimento_Barrinha_Forca();
		Movimento_Personagem();
		
	}

	static void Tela_Inicial() {
		telainicial.setTitle("BEM VINDO AO ANGRY BIRDS");
		telainicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telainicial.setSize(1300, 700);
		telainicial.setLocation(0, 0);
		telainicial.setResizable(false);
		telainicial.setLayout(null);
		telainicial.setVisible(true);

		telainicial.add(play).setBounds(550, 550, 200, 100);
		play.setForeground(Color.BLUE);
		play.setFont(fonte);

		telainicial.add(ajuda1).setBounds(25, 25, 150, 50);
		ajuda1.setForeground(Color.BLUE);
		ajuda1.setFont(fonte);

		telainicial.add(sair1).setBounds(25, 100, 150, 50);
		sair1.setForeground(Color.BLUE);
		sair1.setFont(fonte);
		telainicial.add(bird).setBounds(0, 0, 1300, 700);
	}

	static void Tela_Menu() {
		telamenu.setTitle("MENU");
		telamenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telamenu.setSize(1300, 700);
		telamenu.setLocation(0, 0);
		telamenu.setResizable(false);
		telamenu.setLayout(null);
		telamenu.setVisible(true);

		telamenu.add(jogar).setBounds(550, 550, 150, 100);
		jogar.setForeground(Color.BLUE);
		jogar.setFont(fonte);

		telamenu.add(tutorial).setBounds(25, 25, 150, 50);
		tutorial.setForeground(Color.BLUE);
		tutorial.setFont(fonte);

		telamenu.add(voltar).setBounds(25, 100, 150, 50);
		voltar.setForeground(Color.BLUE);
		voltar.setFont(fonte);

	}

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

	static void Componentes_Tela() {

		tela.add(red).setBounds(50, 530, 50, 55);
		tela.add(red1).setBounds(100, 400, 100, 50);
		red.setVisible(true);
		red1.setVisible(false);
		tela.add(barrinha_de_forca).setBounds(35, 200, 30, 200);
		tela.add(estilingue);
		estilingue.setBounds(posEstiligueeX, posEstiligueeY, 200, 200);
		//tela.add(reiniciar).setBounds(10, 10, 50, 50);
		//reiniciar.setBackground(Color.white);
		tela.add(pig).setBounds(800,470,150,150);
		tela.add(pig1).setBounds(900,470,150,150);
		tela.add(pig2).setBounds(1000,460,150,150);
		tela.add(fundo).setBounds(0, 0, 1365, 650);

		tela.setJMenuBar(janelinha);
		janelinha.add(menu);
		menu.add(informacao);
		menu.add(ajuda);
		menu.add(sair);
		informacao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"TELA INSPIRADA NO JOGO ANGRY BIRDS:" + " DESENVOLVIDA POR AMANDA, EDWIN E GUILHERME MAEDA");
			}
		});
		ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TECLE ENTER PARA LANÇAR O PASSARINHO RED");
			}
		});
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	static void Barrinha_Forca() {

		barrinha_de_forca.setBackground(Color.BLACK);
		barrinha_de_forca.setForeground(Color.RED);
		barrinha_de_forca.setVisible(true);
		barrinha_de_forca.setStringPainted(true);

	}

	static void Movimento_Barrinha_Forca() {
		for (int numero = 0; numero <= 100; numero++) {
			barrinha_de_forca.setValue(numero);
			try {
				Thread.sleep(15);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Teclado();
			if (movimento) {
				break;
			}
			if (numero == 100) {
				for (numero = 100; numero >= 0; numero--) {
					barrinha_de_forca.setValue(numero);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Teclado();
					if (movimento) {
						break;
					}
				}
			}
		}
	}

	static void addMovimento() {
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

	static void Movimento_Personagem() {

		double x = 0;
		double y = 0;
		double t = 1;
		double g = 9.8;
		double f = forca;
		double angulo = 35 * (Math.PI / 180);
		double cosseno = (Math.cos(angulo));
		double seno = (Math.sin(angulo));
		int x1 = 100;
		int y1 = 50;

		red.setVisible(false);
		red1.setVisible(true);
		while (y >= 0 && x <= 1365) {
			red1.setLocation((int) x, (((int) y - 550) * (-1)));
			x = (x1 + (f * cosseno * t));
			y = (y1 + (f * seno * t) - ((g * (t * t)) / 2));
			t = t + 0.01;
			if (y <= 50.0 && t > 0) {
				f = f * 0.6;
				x1 = (int) x;
				y1 = 1;
				y = 0;
				t = 0;
			}

			int v = Forca_Barrinha();
			try {
				Thread.sleep(v);
			} catch (InterruptedException e1) {

			}
			red1.setBounds(red1.getX(),red1.getY(),100,50);
			if (bateu(red1,pig)){
				JOptionPane.showMessageDialog(null, "Você acertou");
			}
		}
		
	}

	static void Teclado() {
		tela.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					movimento = true;
					forca = barrinha_de_forca.getValue();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					movimento = true;
					forca = barrinha_de_forca.getValue();
				}
			}
		});
		tela.getKeyListeners();
	}

	static int Forca_Barrinha() {
		int forrca = 0;
		if (forca >= 0 && forca <= 100) {
			forrca = 1;
		}

		return forrca;

	}

	static void Botoes() {
		reiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tela();
			}
		});
		ajuda1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,"PARA O INICIO DO JOGO É SÓ CLICAR EM PLAY, NO MENU PRINCIPAL VOCÊ IRA ENCONTRAR O TUTORIAL PARA AUXILIALO. BOM JOGO!!!");

			}
		});
		
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telainicial.setVisible(false);
				Tela_Menu();			

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
				telamenu.setVisible(false);
				Tela();
				

			}
		});
		tutorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,tutorial123);

				

			}
		});
		voltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telamenu.setVisible(false);
				Tela_Inicial();
				

			}
		});
	}
	public static boolean bateu(Component a, Component b) {
		int aX = a.getX();
		int aY = a.getY();
		int ladoDireitoA = aX+a.getWidth();
		int ladoEsquerdoA= aX;
		int ladoBaixoA= aY+a.getHeight();
		int ladoCimaA= aY;
		
		int bX = b.getX();
		int bY = b.getY();
		int ladoDireitoB = bX+b.getWidth();
		int ladoEsquerdoB= bX;
		int ladoBaixoB= bY+b.getHeight();
		int ladoCimaB= bY;
		
		boolean bateu = false;
		
		boolean cDireita=false;
		boolean cCima=false;
		boolean cBaixo=false;
		boolean cEsquerda=false;
		
		if(ladoDireitoA>=ladoEsquerdoB) {
			cDireita=true;
		}
		if(ladoCimaA<=ladoBaixoB) {
			cCima=true;
		}
		if(ladoBaixoA>=ladoCimaB) {
			cBaixo=true;
		}
		if(ladoEsquerdoA<=ladoDireitoB) {
			cEsquerda=true;
		}
		
		if(cDireita && cEsquerda && cBaixo && cCima) {
			bateu = true;
		}
			
		return bateu;
	}


}