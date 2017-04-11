package fr.MrBn100ful.ExanLauncher;
/**
 *  Main of the program.
 *  
 * @author MrBn100ful
 * 
 */




import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

import fr.MrBn100ful.ButtonAPI.ButtonAPI;
import fr.MrBn100ful.ExanLauncher.Blurred.Dwmapi;


@SuppressWarnings("serial")
public class Main extends JFrame {
	@SuppressWarnings("unused")
	private static Main instance;
	@SuppressWarnings("unused")
	private Frame frame;
	public JTextArea clock;
	public JLabel dropicon;
	public JFrame style = new JFrame();
	public JFrame main = new JFrame();
	public JButton hide = new JButton(". . . .");
	

	@SuppressWarnings("unused")
	private DragAndDropIcon DragAndDropIcon;


	@SuppressWarnings({ "resource", "unused" })
	public Main(Component c) throws IOException {
		
		String[] lists = AutoUpdate.AutoUpdate();
		File config = new File("config.txt");
		
		
		
		
		
		
		
		if(!config.exists() && !config.isDirectory()) { 
			FileWriter iconinfowriter = new FileWriter(config);
			
			String configplace = "r";
			iconinfowriter.write(configplace);
			iconinfowriter.flush();
			iconinfowriter.close();
			
		}
		
		String configpath = "config.txt";
		
		String configfile = new String(Files.readAllBytes(Paths.get(configpath)));

		main.setType(javax.swing.JFrame.Type.UTILITY);
		style.setType(javax.swing.JFrame.Type.UTILITY);
		
		File file = new File("debug.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		

		
		File iconinfo = new File("iconinfo.txt");
		System.out.println("[Debug] :  Program launched");
		if(iconinfo.exists() && !iconinfo.isDirectory()) { 
			FileReader iconinforead = new FileReader("iconinfo.txt");
			int iconinfonumber = iconinforead.read();
			System.out.println("[Debug] :  " + (iconinfonumber - 1) + " icon(s) created");
		}
		

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		main.setTitle("ExanLauncher");
		main.setSize(60, 680 );
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		if (configfile.equals("r")){
			
			main.setLocation((width - 60), (height / 2) - 340);
			style.setLocation((width - 60), (height / 2) - 340);
		}else {
			
			main.setLocation(0, (height / 2) - 340);
			style.setLocation(60, (height / 2) - 340);
			
		}
		
		main.setUndecorated(true);
		main.setAlwaysOnTop(true);
		main.setResizable(false);
		main.setContentPane(frame = new Frame());
		
		
		main.setBackground(new Color(243, 243, 243, 150));

		dropicon = new JLabel();
		dropicon.setBounds(0, 0, 60, height);
		main.add(dropicon);
		DragAndDropIcon DropIcon = new DragAndDropIcon();
		new DropTarget(dropicon, DropIcon);

		
		style.setTitle("ExanLauncher");
		style.setSize(2, 680);
		
		style.setUndecorated(true);
		style.setAlwaysOnTop(true);
		style.setResizable(false);
		style.setBackground(new Color(243, 243, 243, 185));
		style.setVisible(true);
		main.setVisible(true);
		HWND hwnd = new HWND(Native.getWindowPointer(main));
		Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
		pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
		pBlurBehind.fEnable = true;
		pBlurBehind.fTransitionOnMaximized = false;
		Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);
		

		Icon1();
		Icon2();
		Icon3();
		Icon4();
		Icon5();
		Icon6();
		Icon7();
		Icon8();
		Icon9();
		Icon10();
		
		hide.setBounds(0, 665, 60, 15);
		hide.setContentAreaFilled(false);
		hide.setBorderPainted(false);
		hide.setFocusPainted(false);
		
		hide.setBorderPainted(false);
		hide.setFocusPainted(false);
		hide.setOpaque(false);
		main.add(hide);
		
		hide.addActionListener(new ActionListener() { 
			 
			public void actionPerformed(ActionEvent e) { 
				main.setVisible(false);
				style.setVisible(false);
				JFrame stophide = new JFrame();
				
				stophide.setSize(15, 30);
				stophide.setResizable(false);
				stophide.getContentPane().setLayout(null);
				stophide.setUndecorated(true);
				stophide.setType(javax.swing.JFrame.Type.UTILITY);
				JButton stophideicon = new JButton("<");
				if (configfile.equals("r")){
					
					stophide.setLocation((width - 15), (height / 2));
				}else {
					
					stophide.setLocation(0, (height / 2) );
					
				}
				stophide.setBackground(new Color(243, 243, 243, 150));
				stophideicon.setBounds(0, 0, 15, 30);
				stophideicon.setOpaque(false);
				stophideicon.setContentAreaFilled(false);
				stophideicon.setBorderPainted(false);
				stophideicon.setFocusPainted(false);
				stophide.add(stophideicon);
				
				stophide.setVisible(true);
				
				stophideicon.addActionListener(new ActionListener() { 
					 
					public void actionPerformed(ActionEvent e) { 
						style.setVisible(true);
						main.setVisible(true);
						
						stophide.setVisible(false);
					  }
				});
				
			  }
		});
		
	}


	public static void main(String[] args) throws IOException {
		ButtonAPI.setSystemLookNFeel();
		ButtonAPI.setResourcePath("/fr/MrBn100ful/ExanLauncher/resources");
		instance = new Main(null);
		
	}
	
	public void Icon1 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		
		ImageIcon icon1 = new ImageIcon("icon1.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 70, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon1.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon1.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon2 () {
		
		 try {
         UIManager.setLookAndFeel(
                 UIManager.getSystemLookAndFeelClassName());
     } catch (Exception e) {
         e.printStackTrace();
     }
		
		
		ImageIcon icon1 = new ImageIcon("icon2.png");
    JButton buttonicon1 = new JButton(icon1);
    buttonicon1.setBounds(0, 130, 60, 60);
    buttonicon1.setBorder(null);
    buttonicon1.setOpaque(false);
    buttonicon1.setContentAreaFilled(false);
    buttonicon1.setBorderPainted(false);
    buttonicon1.setFocusPainted(false);
    
    main.add(buttonicon1);
    buttonicon1.addActionListener(new ActionListener()
    {
      @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
      {
    	 
    	  File iconinfo = new File("icon2.txt");
    	  try {
    		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
    			String filepath = "icon2.txt";
    			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
 				Process process = new ProcessBuilder(iconfile).start();
 				System.out.println("[Debug] :  Launch program");
    			
    			}else {
    				System.out.println("[Debug] :  Icon is not created");
    				
    			}
    		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
      }
    });
    System.out.println("[Debug] :  Drag and drop icon activated");
    SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon3 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon3.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 190, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon3.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon3.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon4 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon4.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 250, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon4.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon4.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon5 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon5.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 310, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon5.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon15.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon6 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon6.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 370, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon6.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon6.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}

	public void Icon7 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon7.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 430, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon7.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon7.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	
	public void Icon8 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon8.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 490, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon8.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon8.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon9 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon9.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 550, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon9.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon9.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}
	public void Icon10 () {
		
		 try {
           UIManager.setLookAndFeel(
                   UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		ImageIcon icon1 = new ImageIcon("icon10.png");
      JButton buttonicon1 = new JButton(icon1);
      buttonicon1.setBounds(0, 610, 60, 60);
      buttonicon1.setBorder(null);
      buttonicon1.setOpaque(false);
      buttonicon1.setContentAreaFilled(false);
      buttonicon1.setBorderPainted(false);
      buttonicon1.setFocusPainted(false);
      main.add(buttonicon1);
      buttonicon1.addActionListener(new ActionListener()
      {
        @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e)
        {
      	 
      	  File iconinfo = new File("icon10.txt");
      	  try {
      		 if(iconinfo.exists() && !iconinfo.isDirectory()) { 
      			String filepath = "icon10.txt";
      			String iconfile = new String(Files.readAllBytes(Paths.get(filepath)));
   				Process process = new ProcessBuilder(iconfile).start();
   				System.out.println("[Debug] :  Launch program");
      			
      			}else {
      				System.out.println("[Debug] :  Icon is not created");
      				
      			}
      		
			} catch (IOException e2) {
				System.out.println("[Debug] :  Launch error");
				e2.printStackTrace();
			}
        }
      });
      System.out.println("[Debug] :  Drag and drop icon activated");
      SwingUtilities.updateComponentTreeUI(main);
	}

}
