/**
 *  pfBrowser.js  
 *  
 *  Este � o arquivo que cont�m as fun��es Java para
 *  controle do Browser
 *
 *  @author Ubaldo H. Mattos
 */

//=======================================================================================================
// Tronks: Esta fun��o fecha a aba do navegador onde est� sendo executado o MIRA cine's viewer.
// Observa��o: Note que o comando window.close() � chamado duas vezes. Isto � devido ao navegador Firefox 
// ser diferente dos outros navegadores e s� permitir que se feche a janela ap�s a execu��o do comando "netscape.security.PrivilegeManager.enablePrivilege('UniversalBrowserWrite');" 
// Quaisquer d�vidas entre em contato com Tronks.
function popitup() {
				newwindow=window.open('http://www.mira.med.br','name','height=564,width=1016');
				if (window.focus) {newwindow.focus()}
				return false;
			}
//=======================================================================================================