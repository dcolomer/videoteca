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
.Estilo10 {font-family: Arial, Helvetica, sans-serif}
.Estilo11 {font-size: 12px}
.Estilo12 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; }
.Estilo13 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold;}
.Estilo16 {color: #000000}
.Estilo17 {font-size: 12px; font-weight: bold; font-style: italic; font-family: Arial, Helvetica, sans-serif;}
-->
</style>

</head>
<body>

<table id="wrapper" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
<tbody>

<tr>

<td style="text-align: right; height: 9%; width: 90%; background-color: rgb(83, 83, 82);">
  <div align="right"><img src="images/t_ordenar.gif" alt="" width="200" height="60" align="left" style="width: 200px; height: 60px;">
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

<table align="center" width="75%" height="100%"  border="1" cellpadding="5" cellspacing="4">

<form enctype="multipart/form-data" action="Controlador">

<input type="hidden" name="operacion" value="opOrdenarPeliculas"/>


  <tr bgcolor="A6B4BF">
    <td><span class="Estilo17">Realizar la ordenaci�n sobre el siguiente elemento:</span></td>	
    </tr>
  
  <tr>
  <td align="center" bgcolor="D6E7FA">
  	<p class="Estilo12">&nbsp;
		  </p>
  	<p class="Estilo12">
		      <input type="radio" name="campo_orden" value="id_pelicula" checked>
		    Identificador
            <input type="radio" name="campo_orden" value="titulo">
            Titulo
            <input type="radio" name="campo_orden" value="director">
            Director
              <input type="radio" name="campo_orden" value="localizacion">
              Localizacion
              <input type="radio" name="campo_orden" value="genero">
              Genero1/2
        <input type="radio" name="campo_orden" value="visualizada">
        Visualizadas </p>
  	<hr>    <p>
  	  <input name="btn_ordenar" type="submit" id="btn_ordenar" value="Ordenar">
  	</p>  	</td>
  </tr>
  
  
  <tr>
    <td bgcolor="A6B4BF"><div align="right"><img src="images/orden.gif" width="99" height="56"></div></td>	
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