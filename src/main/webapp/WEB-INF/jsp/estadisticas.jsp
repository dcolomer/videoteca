<%@ page import="java.util.*, beans.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<SCRIPT type="text/javascript">

image0 = new Image();
image0.src = "./images/inicio.gif";
image1 = new Image();
image1.src = "./images/retroceder.gif";

</SCRIPT>

<style type="text/css">
<!--
.Estilo18 {font-style: italic; font-family: Arial, Helvetica, sans-serif; font-size: 12px;}
-->
</style>

</head>
<body>

<table id="wrapper" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
<tbody>

<tr>

<td style="text-align: right; height: 9%; width: 90%; background-color: rgb(83, 83, 82);">
  <div align="right"><img src="images/t_estad.gif" alt="" width="200" height="60" align="left" style="width: 200px; height: 60px;">
      <img src="./images/videoteca.gif" alt="" width="614" height="40" align="top" style="width: 250px; height: 40px;"> </div>	  </td>

</tr>

<tr>
<td valign="top" style="height: 79%; width: 100%; background-color: silver;">


 <table width="100%" height="100%" border="0" cellpadding="5" cellspacing="2" 
style="background-color: silver; text-align: left; margin-left: auto; margin-right: auto; width: 100%; height: 100%;">
<tbody>

<tr>

<td width="84%" valign="top" style="text-align: right;">
<a href="Controlador?operacion=opIndex" onmouseover="image2.src='./images/inicio_satinado.gif';" onmouseout="image2.src='./images/inicio.gif';"><img src="images/inicio.gif" alt="" name="image2" width="57" height="23" style="border: 0px solid ; width: 57px; height: 23px;"></a>
</td>

<td width="16%" valign="top" style="text-align: right;">
<a href="javascript:history.back( )" onmouseover="image3.src='./images/retroceder_satinado.gif';" onmouseout="image3.src='./images/retroceder.gif';"><img src="images/retroceder.gif" alt="" name="image3" width="102" height="23" style="border: 0px solid ; width: 102px; height: 23px;"></a>
</td>

</tr>

<tr>
<td colspan="2" valign="top">

<table align="center" width="51%" height="100%"  border="1" cellpadding="2" cellspacing="2">

  <tr bgcolor="A6B4BF">
    <td colspan="4" class="Estilo18"><div align="center"><strong>Datos generales </strong></div></td>
    </tr>

	<%
	int total_entradas=Integer.parseInt(request.getAttribute("total_entradas").toString());
	int total_pelis=Integer.parseInt(request.getAttribute("total_pelis").toString());
	int total_docums=Integer.parseInt(request.getAttribute("total_docums").toString());
	int total_series=Integer.parseInt(request.getAttribute("total_series").toString());
	int total_informatica=Integer.parseInt(request.getAttribute("total_informatica").toString());	
	int total_otros=Integer.parseInt(request.getAttribute("total_otros").toString());
	
	int total_accion=Integer.parseInt(request.getAttribute("total_accion").toString());
	int total_adultos=Integer.parseInt(request.getAttribute("total_adultos").toString());
    int total_ficcion=Integer.parseInt(request.getAttribute("total_ficcion").toString());
	int total_comedia=Integer.parseInt(request.getAttribute("total_comedia").toString());
	int total_drama=Integer.parseInt(request.getAttribute("total_drama").toString());	
	int total_infantil=Integer.parseInt(request.getAttribute("total_infantil").toString());
	int total_musical=Integer.parseInt(request.getAttribute("total_musical").toString());
	int total_thriller=Integer.parseInt(request.getAttribute("total_thriller").toString());
	int total_policiaca=Integer.parseInt(request.getAttribute("total_policiaca").toString());
	int total_western=Integer.parseInt(request.getAttribute("total_western").toString());									
	int total_historica=Integer.parseInt(request.getAttribute("total_historica").toString());									
	int total_epoca=Integer.parseInt(request.getAttribute("total_epoca").toString());									
	int total_terror=Integer.parseInt(request.getAttribute("total_terror").toString());									
	int total_otros_pelicula=Integer.parseInt(request.getAttribute("total_otros_pelicula").toString());									
	
	%>

  <tr bgcolor="A6B4BF">
    <td width="33%" bgcolor="D6E7FA" class="Estilo18">Entradas  en la base de datos </td>		
    <td width="17%" bgcolor="#E8F1FE" class="Estilo18"><div align="right">
        <% out.println(total_entradas); %>
    </div></td>
    <td width="33%" bgcolor="D6E7FA" class="Estilo18">Total series</td>
    <td width="17%" bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_series); %>
      </div>
</div></td>
  </tr>
  
  <tr bgcolor="D6E7FA">
  <td bgcolor="D6E7FA" class="Estilo18">Total peliculas</td>
  <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <% out.println(total_pelis); %>
  </div></td>
  <td class="Estilo18">Total informatica</td>
  <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <% out.println(total_informatica); %>
  </div></td>
  </tr>
    
  <tr bgcolor="A6B4BF">
    <td bgcolor="D6E7FA"><span class="Estilo18">Total documentales </span></td>
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
        <% out.println(total_docums); %>
    </div></td>
    <td bgcolor="D6E7FA"><span class="Estilo18"></span><span class="Estilo18">Total otros</span></td>
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_otros); %>
      </div>
</div></td>
  </tr>
  
 
  
</table>

</td>
</tr>


<tr>
<td colspan="2" valign="top">

<table align="center" width="74%" height="100%"  border="1" cellpadding="2" cellspacing="2">

  <tr bgcolor="A6B4BF">
    <td colspan="8" class="Estilo18"><div align="center"><strong>Datos especificos pel&iacute;culas</strong></div></td>
    </tr>
  <tr bgcolor="A6B4BF">
    <td width="12%" bgcolor="D6E7FA" class="Estilo18">acci&oacute;n</td>	
    <td width="13%" bgcolor="#E8F1FE" class="Estilo18"><div align="right">
          <% out.println(total_accion); %>
    </div></td>
    <td width="13%" bgcolor="D6E7FA" class="Estilo18">drama</td>
    <td width="13%" bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_drama); %>
      </div>
    </div></td>
    <td width="13%" bgcolor="D6E7FA"><span class="Estilo18">policiaca</span></td>
    <td width="12%" bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_policiaca); %>
      </div>
    </div></td>
    <td width="12%" bgcolor="D6E7FA"><span class="Estilo18">otro</span></td>
    <td width="12%" bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_otros_pelicula); %>
      </div>
    </div></td>
  </tr>
  
  <tr bgcolor="D6E7FA">
  <td bgcolor="D6E7FA" class="Estilo18">adultos</td>
  <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
    <div align="right">
      <% out.println(total_adultos); %>
    </div>
  </div></td>
  <td class="Estilo18">infantil</td>
  <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
    <div align="right">
      <% out.println(total_infantil); %>
    </div>
  </div></td>
  <td bgcolor="D6E7FA"><span class="Estilo18">western</span></td>
  <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
    <div align="right">
      <% out.println(total_western); %>
    </div>
  </div></td>
  <td bgcolor="D6E7FA">&nbsp;</td>
  <td bgcolor="#E8F1FE"><div align="right"></div></td>
  </tr>
    
  <tr bgcolor="A6B4BF">
    <td bgcolor="D6E7FA"><span class="Estilo18">ficci&oacute;n</span></td>
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_ficcion); %>
      </div>
    </div></td>
    <td bgcolor="D6E7FA"><span class="Estilo18">musical</span></td>
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_musical); %>
      </div>
    </div></td>
    <td bgcolor="D6E7FA"><span class="Estilo18">hist&oacute;rica</span></td>
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_historica); %>
      </div>
    </div></td>
    <td bgcolor="D6E7FA">&nbsp;</td>
    <td bgcolor="#E8F1FE"><div align="right"></div></td>
  </tr>
  <tr bgcolor="A6B4BF">
    <td bgcolor="D6E7FA"><div align="left"><span class="Estilo18">comedia</span></div></td>	
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_comedia); %>
      </div>
    </div></td>
    <td bgcolor="D6E7FA"><div align="left"><span class="Estilo18">thriller</span></div></td>
    <td bgcolor="#E8F1FE"><div align="right">
      <div align="right" class="Estilo18">
        <% out.println(total_thriller); %>
      </div>
    </div></td>
    <td bgcolor="D6E7FA"><span class="Estilo18">&eacute;poca</span></td>
    <td bgcolor="#E8F1FE" class="Estilo18"><div align="right">
      <div align="right">
        <% out.println(total_epoca); %>
      </div>
    </div></td>
    <td bgcolor="D6E7FA">&nbsp;</td>
    <td bgcolor="#E8F1FE"><div align="right"></div></td>
  </tr>
  
 
  
</table>

</td>
</tr>


</tbody>
</table>

<tr>
<td style="background-color: rgb(83, 83, 82); height: 8%;"><img style="width: 186px; height: 27px;" alt="" src="./images/copyright.gif"></td>
</tr>
</tbody>
</table>



</body>
</html>