package fr.MrBn100ful.ExanLauncher;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;






public class Option {
	
	static JButton delallicon = new JButton("Deletes all icons");
	static JButton closeexanlauncher = new JButton("Close ExanLauncher");
	
	public static JFrame optionmenu = new JFrame();

	public static int var = 1;
	
	public boolean optionMenuOpen = false;
	public boolean optionMenuCreate = false;
	
	static Shutdown shutdown = new Shutdown();
	private static boolean test = false;
	
	public static String[] Optionframe(){
		
		if  ( test != true ){
			style1();
			
			test = true;
		}
			
		optionmenu.setTitle("Program Option");
			
			optionmenu.setSize(255, 115);
			optionmenu.setLocation(1400, 180);
			optionmenu.setResizable(false);
			
			optionmenu.setVisible(true);

			
			
			delallicon.setBounds(0, 0, 120, 90);
			closeexanlauncher.setBounds(120, 0, 130, 90);
			
			optionmenu.add(delallicon);
			
			
			optionmenu.add(closeexanlauncher);
			
			closeexanlauncher.addActionListener(new ActionListener() { 
				 
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  stop button press");
						System.exit(0);
				  }
			});
			
			
			delallicon.addActionListener(new ActionListener() { 
				  @SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) { 
						System.out.println("[Debug] :  delicon button press");
						
						while (var < 11) {
							File file = new File("icon" + var + ".txt");
							file.delete();
							
							File file2 = new File("icon" + var + ".png");
							file2.delete();
							
							File file2d = new File("debug.txt");
							file2d.delete();
							
							File filed = new File("iconinfo.txt");
							filed.delete();
							
							FileWriter iconinforead;
							try {
								iconinforead = new FileWriter("iconinfo.txt");
								iconinforead.write("");
								iconinforead.flush();
								iconinforead.close();
							} catch (IOException e1) {
								System.out.println("[Debug] :  reste iconinfo.txt bug");
								e1.printStackTrace();
							}

							
                			
							
							
							var = var + 1;
						}
						try {
							shutdown.restartApplication(null);
						} catch (IOException e1) {
							System.out.println("[Debug] :  Restart bug");
							e1.printStackTrace();
						}
				  } 
				} );
			return null;
	}
public static void style1 (){
	optionmenu.setType(javax.swing.JFrame.Type.UTILITY);
	
}
}
