<%@ page import="java.util.*, beans.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
    <style>
        .thumb {
            height: 75px;
            border: 1px solid #000;
            margin: 10px 5px 0 0;
        }
    </style>
<SCRIPT type="text/javascript">

image0 = new Image();
image0.src = "./images/inicio.gif";
image1 = new Image();
image1.src = "./images/retroceder.gif";

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

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


<form method="post" name="form1" enctype="multipart/form-data" action="Controlador">

<input type="hidden" name="operacion" value="opAnadirPeliculas"/>
<input type="hidden" name="id_pelicula" value="<%= request.getAttribute("id_pelicula") %>"/>


<table id="wrapper" border="0" cellpadding="0" cellspacing="1" bgcolor="silver">
<tbody>

<tr>

<td style="text-align: right; height: 9%; width: 90%; background-color: rgb(83, 83, 82);">
  <div align="right"><img src="images/t_anadir.gif" alt="" width="200" height="60" align="left" style="width: 200px; height: 60px;">
      <img src="./images/videoteca.gif" alt="" width="614" height="40" align="top" style="width: 250px; height: 40px;"> </div>
	  </td>

</tr>

<tr>
<td valign="top" style="width: 100%; background-color: silver;">

 <table width="100%" height="100%" border="0" cellpadding="5" cellspacing="2" 
style="background-color: silver; text-align: left; margin-left: auto; margin-right: auto; width: 100%; height: 100%;">
<tbody>

<tr>

<td width="84%" style="text-align: right;">
<a href="Controlador?operacion=opIndex" onmouseover="image0.src='./images/inicio_satinado.gif';" onmouseout="image0.src='./images/inicio.gif';"><img src="images/inicio.gif" alt="" name="image0" width="57" height="23" style="border: 0px solid ; width: 57px; height: 23px;"></a>
</td>

<td width="16%" style="text-align: right;">
<a href="javascript:history.back( )" onmouseover="image1.src='./images/retroceder_satinado.gif';" onmouseout="image1.src='./images/retroceder.gif';"><img src="images/retroceder.gif" alt="" name="image1" width="102" height="23" style="border: 0px solid ; width: 102px; height: 23px;"></a>
</td>

</tr>

<tr>

<td valign="top" colspan="6">  
<table width="100%" height="100%"  border="1" cellpadding="3" cellspacing="1">

  <tr>
    <td width="15%" bgcolor="A6B4BF"><span class="Estilo17">Codigo</span></td>	
    <td width="26%" bgcolor="D6E7FA"><span class="Estilo12">Nuevo</span></td>
    <td width="12%" bgcolor="A6B4BF"><span class="Estilo17">Genero1</span></td>
    <td width="25%" bgcolor="D6E7FA"><span class="Estilo12"><select name="genero1">

<% 
	Collection c_genero1 = (Collection) request.getAttribute("listado_genero1");
				 		
   				Iterator it = c_genero1.iterator();
				while (it.hasNext()) { 
    					Codigos codVO =
    						(Codigos) it.next();
				%>
                        <option value="<%= codVO.getValor() %>">
                        <% out.println(codVO.getValor()); %>
                        </option>
				<%} 
                %>
                                </select></span></td>

 </tr>
  <tr>
    <td rowspan="2" bgcolor="A6B4BF"><span class="Estilo17">Titulo<br>Subtitulo</span></td>
    <td rowspan="2" bgcolor="E8F1FE"><span class="Estilo13"><input name="titulo" type="text" size="50" maxlength="100"><BR>
	<input name="subtitulo" type="text" size="50" maxlength="100"></span></td>
	
	<td bgcolor="A6B4BF"><span class="Estilo17">Genero2</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><select name="genero2">

<% 
	Collection c_genero2 = (Collection) request.getAttribute("listado_genero2_3");
				 		
   				it = c_genero2.iterator();
				while (it.hasNext()) { 
    					Codigos codVO =
    						(Codigos) it.next();
				%>
                        <option value="<%= codVO.getValor() %>">
                        <% out.println(codVO.getValor()); %>
                        </option>
				<%} 
                %>
                                </select></span></td>
								
</tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Genero3</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><select name="genero3">

<% 
	Collection c_genero3 = (Collection) request.getAttribute("listado_genero2_3");
				 		
   				it = c_genero3.iterator();
				while (it.hasNext()) { 
    					Codigos codVO =
    						(Codigos) it.next();
				%>
                        <option value="<%= codVO.getValor() %>">
                        <% out.println(codVO.getValor()); %>
                        </option>
				<%} 
                %>
                                </select></span></td>
								

</tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Composicion</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><select name="composicion">

<% 
	Collection c_composicion = (Collection) request.getAttribute("listado_composicion");
   				it = c_composicion.iterator();
				while (it.hasNext()) {
						
    					Codigos codVO = (Codigos) it.next();
				%>
                        <option value="<%= codVO.getValor() %>">
                        <% out.println(codVO.getValor()); %>
                        </option>
				<%
								
				} 
                %>
                                </select></span></td>
								

<td bgcolor="A6B4BF"><span class="Estilo17">Vista?</span> 
		
	</td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><select name="visualizada">
	<option value="0" selected>No</option>
	<option value="1">Si</option>
</select></span></td>

</tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Formato</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><select name="formato">

<% 
	Collection c_formato = (Collection) request.getAttribute("listado_formato");
				 		
   				it = c_formato.iterator();
				while (it.hasNext()) { 
    					Codigos codVO =
    						(Codigos) it.next();
				%>
                        <option value="<%= codVO.getValor() %>">
                        <% out.println(codVO.getValor()); %>
                        </option>
				<%} 
                %>
                                </select></span></td>
								
<td bgcolor="A6B4BF"><span class="Estilo17">Num. vis.</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><select name="num_visualizaciones">
	<option value="0" selected>0</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>	
	<option value="9">9</option>
</select></span></td>

</tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Tipo</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><select name="tipo">

<% 
	Collection c_tipo = (Collection) request.getAttribute("listado_tipo");
				 		
   				it = c_tipo.iterator();
				while (it.hasNext()) { 
    					Codigos codVO =
    						(Codigos) it.next();
				%>
                        <option value="<%= codVO.getValor() %>">
                        <% out.println(codVO.getValor()); %>
                        </option>
				<%} 
                %>
                                </select></span></td>
								
								
<td bgcolor="A6B4BF"><span class="Estilo17">Director</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><input name="director" type="text" size="50" maxlength="100">
	</span></td>
	
	</tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Localizacion</span></td>
	<td bgcolor="E8F1FE"><span class="Estilo12"><input name="localizacion" type="text" size="10" maxlength="10">
	</span></td>
	
	<td bgcolor="A6B4BF"><span class="Estilo17">Actor1</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><input name="actor1" type="text" size="50" maxlength="100">
	</span></td>
	
	</tr>
  <tr>
      <td bgcolor="A6B4BF" rowspan="2"><span class="Estilo17">Version orig. sub.</span></td>
      <td bgcolor="D6E7FA" rowspan="2"><span class="Estilo12"><select name="vos">
	<option value="0" selected>No</option>
	<option value="1">Si</option>
</select></span></td>

<td bgcolor="A6B4BF"><span class="Estilo17">Actor2</span></td>
      <td bgcolor="E8F1FE"><span class="Estilo12"><input name="actor2" type="text" size="50" maxlength="100">
</span></td>

</tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Actor3</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><input name="actor3" type="text" size="50" maxlength="100">
</span></td>

</tr>
<tr>
    <td height="35" bgcolor="A6B4BF"><span class="Estilo17">Notas</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><div align="left">
	<textarea cols=40 rows=5 NAME="observaciones" maxlength="250" onkeyup="return ismaxlength(this)"></textarea>
	</div></span></td>
	
    <td bgcolor="A6B4BF"><span class="Estilo17">Caratula</span></td>
    <td bgcolor="E8F1FE">
        <span class="Estilo13">
            <input type="file" id="caratula" name="caratula" size="50" maxlength="100"><br>
            <div id="imagen_caratula"></div>
	    </span>
    </td>
	
</tr>

	
</table></td>
</tr>


</tbody>
</table>

<div align="center"><input name="btn_guardar" type="submit" id="btn_guardar" value="Grabar pelicula"></div>
<tr>
<td style="background-color: rgb(83, 83, 82); height: 8%;"><img style="width: 186px; height: 27px;" alt="" src="./images/copyright.gif"></td>
</tr>
</tbody>
</table>

</form>

<script type="text/javascript">
 document.form1.titulo.focus();
</script>

<script src='js/cargar-fichero.js'></script>

</body>
</html>																																												