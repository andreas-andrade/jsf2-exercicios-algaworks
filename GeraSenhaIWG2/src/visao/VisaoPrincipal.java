package visao;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.Font;
import javax.swing.JComboBox;

public class VisaoPrincipal extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField textSenha = null;
	private JButton botaoGerar = null;
	private JButton botaoSair = null;
	private JLabel labelLic = null;
	private JLabel labelLic1 = null;
	private JTextField textLic = null;
	private JLabel labelAplicacao;
	private JComboBox comboApp;

	/**
	 * This is the default constructor
	 */
	public VisaoPrincipal()
	{
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		this.setSize(348, 269);
		this.setContentPane(getJContentPane());
		this.setTitle("IWG2 License Generator");
		getJContentPane().add(getLabelAplicacao());
		getJContentPane().add(getComboApp());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane()
	{
		if (jContentPane == null)
		{
			labelLic1 = new JLabel();
			labelLic1.setBounds(new Rectangle(11, 151, 135, 24));
			labelLic1.setText("License:");
			labelLic = new JLabel();
			labelLic.setBounds(new Rectangle(11, 75, 138, 23));
			labelLic.setText("Code:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTextSenha(), null);
			jContentPane.add(getBotaoGerar(), null);
			jContentPane.add(getBotaoSair(), null);
			jContentPane.add(labelLic, null);
			jContentPane.add(labelLic1, null);
			jContentPane.add(getTextLic(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes textSenha	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextSenha()
	{
		if (textSenha == null)
		{
			textSenha = new JTextField();
			textSenha.setBounds(new Rectangle(10, 106, 146, 37));
			textSenha.setFont(new Font("Arial", Font.BOLD, 14));
		}
		return textSenha;
	}

	/**
	 * This method initializes botaoGerar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoGerar()
	{
		if (botaoGerar == null)
		{
			botaoGerar = new JButton();
			botaoGerar.setBounds(new Rectangle(190, 53, 116, 37));
			botaoGerar.setText("Generate");
			botaoGerar.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					if ((textSenha.getText() != null) && !textSenha.getText().equals("") && (comboApp.getSelectedIndex() > -1))
					{
						String contraSenha = textSenha.getText().toUpperCase();
						String licenca = "";
						if (comboApp.getSelectedIndex() == 0)
							licenca = sha1(contraSenha+"IWG2PACS");
						else if (comboApp.getSelectedIndex() == 1)
							licenca = sha1(contraSenha+"STERILINK");
						licenca = licenca.substring(0,8).toUpperCase();
						textLic.setText(licenca);
					}
				}
			});
		}
		return botaoGerar;
	}

	/**
	 * This method initializes botaoSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoSair()
	{
		if (botaoSair == null)
		{
			botaoSair = new JButton();
			botaoSair.setBounds(new Rectangle(188, 143, 118, 35));
			botaoSair.setText("Exit");
			botaoSair.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					System.exit(0);
				}
			});
		}
		return botaoSair;
	}

	/**
	 * This method initializes textLic	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextLic()
	{
		if (textLic == null)
		{
			textLic = new JTextField();
			textLic.setBounds(new Rectangle(10, 183, 146, 37));
			textLic.setFont(new Font("Arial", Font.BOLD, 14));
		}
		return textLic;
	}
	
	/**
	 * Retorna um String de caracteres correspondente. 
	 * 
	 * @param senha - String a ser encriptado
	 * @return - Caracteres correspondentes
	 * 
	 * @author chris
	 */
	public static String sha1(String senha){  
        String sen = "";  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("SHA1");  
            BigInteger hash;
			try
			{
				hash = new BigInteger(1, md.digest(senha.getBytes("UTF-8")));
	            sen = hash.toString(36);              
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return sen;  
    }
	private JLabel getLabelAplicacao() {
		if (labelAplicacao == null) {
			labelAplicacao = new JLabel("App:");
			labelAplicacao.setBounds(10, 8, 25, 14);
		}
		return labelAplicacao;
	}
	private JComboBox getComboApp() {
		if (comboApp == null) {
			comboApp = new JComboBox();
			comboApp.setBounds(10, 30, 146, 37);
			comboApp.addItem("IWG2");		
			comboApp.addItem("Sterilink");		
		}
		return comboApp;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
