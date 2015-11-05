/**
 *  pfBrowser.js  
 *  
 *  Este é o arquivo que contém as funções Java para
 *  controle do Browser
 *
 *  @author Ubaldo H. Mattos
 */

//=======================================================================================================
// Tronks: Esta função fecha a aba do navegador onde está sendo executado o MIRA cine's viewer.
// Observação: Note que o comando window.close() é chamado duas vezes. Isto é devido ao navegador Firefox 
// ser diferente dos outros navegadores e só permitir que se feche a janela após a execução do comando "netscape.security.PrivilegeManager.enablePrivilege('UniversalBrowserWrite');" 
// Quaisquer dúvidas entre em contato com Tronks.
function popitup() {
				newwindow=window.open('http://www.mira.med.br','name','height=564,width=1016');
				if (window.focus) {newwindow.focus()}
				return false;
			}
//=======================================================================================================