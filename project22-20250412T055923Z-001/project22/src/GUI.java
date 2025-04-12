import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.TextArea;
import javax.swing.JLabel;


public class GUI extends JFrame {
	Compress compressFile ;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//create Frame 
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		
		//create text area to print data
		TextArea textArea = new TextArea();
		textArea.setBounds(36, 135, 451, 128);
		contentPane.add(textArea);
		
		//jlabel to give the status of operation 
		JLabel label = new JLabel("");
		label.setBounds(41, 286, 261, 23);
		contentPane.add(label);
		
		JButton btnHeader = new JButton("Header");
		btnHeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//print Header into textArea 
				Header header = compressFile.getHeader();
				textArea.setText("File Name: " + header.getFileName()
						+ "\nFile Size: " + header.getFileSize() + "\n "
						+ "Byte " + "  " + "Count \n" );
				//view on screen 
				for (int i=0 ; i<header.getBytes().length ; i++)
					textArea.setText(textArea.getText() + header.getBytes()[i] 
							+ "  " + header.getCount()[i] + "\n");
			}
		});
		btnHeader.setBounds(36, 93, 146, 23);
		btnHeader.setEnabled(false);
		JButton btnHaffmanCode = new JButton("Haffman Code ");
		btnHaffmanCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//print huffman code into screen 
				textArea.setText("Byte \t Huffman Code \n");
				Huffman table[] = compressFile.getHuffTable();
				for (int i =0 ; i <table.length ; i++)
					textArea.setText(textArea.getText() + table[i].byteCount + " \t " +table[i].Huffman + "\n");
			}
		});
		btnHaffmanCode.setBounds(192, 93, 146, 23);
		btnHaffmanCode.setEnabled(false );
		JButton btnFrequancy = new JButton("Frequancy");
		btnFrequancy.setBounds(341, 93, 146, 23);
		btnFrequancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print freq/ count for each byte 
				textArea.setText("Byte \t frequency \n");
				Counter counter[] = compressFile.counter;
				for (int i =0 ; i <counter.length ; i++)
					textArea.setText(textArea.getText() + counter[i].byteCount + " \t " +counter[i].intCount + "\n");
			}
		});
		btnFrequancy.setEnabled(false );
		
		
		
		JButton btnCancel = new JButton("Quit");
		btnCancel.setBounds(341, 286, 146, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		JButton btnCompress = new JButton("Compress");
		btnCompress.setBounds(36, 25, 222, 23);
		btnCompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label.setText("");
				btnFrequancy.setEnabled(true);
				btnHaffmanCode.setEnabled(true);
				btnHeader.setEnabled(true);
				//read file from file browser
				JFileChooser inputFile = new JFileChooser(); 
				int x = inputFile.showOpenDialog(btnCompress);
				if (x == JFileChooser.APPROVE_OPTION){
					File  selectedFile = inputFile.getSelectedFile();
					String File = selectedFile.getPath();
					compressFile = new Compress(File); 
					
					try {
						compressFile.readFile();
						compressFile.createHeap();
						compressFile.writeHuffmanCode();
						label.setText("Compression Done ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton btnDecompress = new JButton("Extract");
		btnDecompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label.setText("");
				btnHeader.setEnabled(false);
				btnFrequancy.setEnabled(false );
				btnHeader.setEnabled(false);
				//choose file using file browser
				JFileChooser inputFile = new JFileChooser(); 
				int x = inputFile.showOpenDialog(btnDecompress);
				if (x == JFileChooser.APPROVE_OPTION){
					File  selectedFile = inputFile.getSelectedFile();
					String File = selectedFile.getAbsolutePath().replace("\\", "\\\\");
					if (File.endsWith(".huf")  ){
						label.setText("In progress... ");

						Decompress decompress = new Decompress(File);
						try {
							decompress.readHuffFile();
							label.setText("Decompression Done ");

						} catch (Exception e) {
							e.printStackTrace();
						}
					}else
						JOptionPane.showMessageDialog(null, "Selected file should be (.huf) file, choose another one.");
					
					
				}
			}
		});
		btnDecompress.setBounds(265, 25, 222, 23);
		contentPane.setLayout(null);
		contentPane.add(btnCancel);
		contentPane.add(btnCompress);
		contentPane.add(btnDecompress);
		contentPane.add(btnHeader);
		contentPane.add(btnHaffmanCode);
		contentPane.add(btnFrequancy);
		
		
		
	}
}
