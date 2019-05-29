<%@ page import="java.util.*, beans.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<SCRIPT type="text/javascript">

image0 = new Image();
image0.src = "./images/m_modificar.gif";
image1 = new Image();
image1.src = "./images/eliminar.gif";
image2 = new Image();
image2.src = "./images/inicio.gif";
image3 = new Image();
image3.src = "./images/retroceder.gif";


function eliminar_pelicula(id_pelicula)
{
	var eliminar=confirm("Se eliminar� la pel�cula de la base de datos �Estas seguro?");

	if (eliminar)
		window.location="Controlador?operacion=opEliminarPelicula&id_pelicula="+id_pelicula;		
 
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

<table id="wrapper" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
<tbody>

<tr>

<td style="text-align: right; height: 9%; width: 90%; background-color: rgb(83, 83, 82);">
  <div align="right"><img src="images/t_ficha.gif" alt="" width="200" height="60" align="left" style="width: 200px; height: 60px;">
      <img src="./images/videoteca.gif" alt="" width="614" height="40" align="top" style="width: 250px; height: 40px;"> </div>
	  </td>

</tr>

<tr>

<td valign="top" style="height: 79%; width: 100%; background-color: silver;">


 <table width="100%" height="100%" border="0" cellpadding="5" cellspacing="2" 
style="background-color: silver; text-align: left; margin-left: auto; margin-right: auto; width: 100%; height: 100%;">
<tbody>

<% try {

				Collection detalle_pelicula = 
				(Collection) request.getAttribute("listado_detalle_pelicula");
				Iterator it = detalle_pelicula.iterator();
				while (it.hasNext()) { 
    					DetallePelicula detalle_peli = (DetallePelicula) it.next();
					%>


<tr>
<td width="17%" style="text-align: left;">
<a href="Controlador?operacion=opFormModificarPelicula&id_pelicula=<%= detalle_peli.getIdPelicula() %>" onMouseOver="image0.src='./images/m_modificar_satinado.gif';" onMouseOut="image0.src='./images/m_modificar.gif';"><img src="images/m_modificar.gif" alt="" name="image0" width="87" height="26" style="border: 0px solid ; width: 87px; height: 21px;"></a></td>


  
<td width="20%" style="text-align: center;">
<a href="javascript:eliminar_pelicula('<%= detalle_peli.getIdPelicula() %>')" 
onmouseover="image1.src='./images/eliminar_satinado.gif';" 
onmouseout="image1.src='./images/eliminar.gif';"><img src="images/eliminar.gif" alt="" name="image1" width="82" height="25" style="border: 0px solid ; width: 82px; height: 25px;">
</a>
</td>



<td width="15%" style="text-align: center;">&nbsp;</td>

<td width="31%" style="text-align: right;">
<a href="Controlador?operacion=opIndex" onmouseover="image2.src='./images/inicio_satinado.gif';" onmouseout="image2.src='./images/inicio.gif';"><img src="images/inicio.gif" alt="" name="image2" width="57" height="23" style="border: 0px solid ; width: 57px; height: 23px;"></a>
</td>

<td width="17%" style="text-align: right;">
<a href="javascript:history.back( )" onmouseover="image3.src='./images/retroceder_satinado.gif';" onmouseout="image3.src='./images/retroceder.gif';"><img src="images/retroceder.gif" alt="" name="image3" width="102" height="23" style="border: 0px solid ; width: 102px; height: 23px;"></a>
</td>

</tr>
<tr><td colspan="6">
<hr>

</td></tr>

<tr>

<td colspan="6">  

<table width="100%" height="100%"  border="1" cellpadding="3" cellspacing="1">




  <tr>
    <td width="15%" bgcolor="A6B4BF"><span class="Estilo17">Codigo</span></td>	
    <td width="26%" bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getIdPelicula()); %></span></td>
    <td width="12%" bgcolor="A6B4BF"><span class="Estilo17">Genero1</span></td>
    <td width="25%" bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getGenero1()); %></span></td>
    <td rowspan="10" bgcolor="A6B4BF"><div align="center"><img border=1 src="ServletImages?id_pelicula=<%= detalle_peli.getIdPelicula() %>"></div></td>
  </tr>
  <tr>
    <td rowspan="2" bgcolor="A6B4BF"><span class="Estilo17">Titulo</span></td>
    <td rowspan="2" bgcolor="E8F1FE"><span class="Estilo13"><% out.println(detalle_peli.getTitulo()); %> <BR>
	<% out.println(detalle_peli.getSubtitulo()); %></span></td>
    <td bgcolor="A6B4BF"><span class="Estilo17">Genero2</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><% out.println(detalle_peli.getGenero2()); %></span></td>
  </tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Genero3</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getGenero3()); %></span></td>
  </tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Composicion</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getComposicion()); %></span></td>
    <td bgcolor="A6B4BF"><span class="Estilo17">Vista?</span> 
		
	</td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><%	                        
		if (detalle_peli.getVisualizada().compareTo("0")==0)
	    	out.println("No");                        	
	    else
	        out.println("Si");                        	
	    %></span></td>
  </tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Formato</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><% out.println(detalle_peli.getFormato()); %></span></td>
    <td bgcolor="A6B4BF"><span class="Estilo17">Num. vis.</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getNumVisualizaciones()); %></span></td>
  </tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Tipo</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getTipo()); %></span></td>
    <td bgcolor="A6B4BF"><span class="Estilo17">Director</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><% out.println(detalle_peli.getDirector()); %></span></td>
  </tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Localizacion</span></td>
    <td bgcolor="E8F1FE"><span class="Estilo12"><% out.println(detalle_peli.getLocalizacion()); %></span></td>
    <td bgcolor="A6B4BF"><span class="Estilo17">Actor1</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getActor1()); %></span></td>
    </tr>
  <tr>
      <td bgcolor="A6B4BF" rowspan="2"><span class="Estilo17">Version orig. sub.</span></td>
      <td bgcolor="D6E7FA" rowspan="2"><span class="Estilo12"><%	                        
	if (detalle_peli.getVos().compareTo("0")==0)
		out.println("No");                        	
	else
		out.println("Si");                        	
	%></span></td>
      <td bgcolor="A6B4BF"><span class="Estilo17">Actor2</span></td>
      <td bgcolor="E8F1FE"><span class="Estilo12"><% out.println(detalle_peli.getActor2()); %></span></td>
  </tr>
  <tr>
    <td bgcolor="A6B4BF"><span class="Estilo17">Actor3</span></td>
    <td bgcolor="D6E7FA"><span class="Estilo12"><% out.println(detalle_peli.getActor3()); %></span></td>
    </tr>
  <tr>
    <td height="71" bgcolor="A6B4BF"><span class="Estilo17">Notas</span></td>
    <td colspan="3" bgcolor="E8F1FE"><span class="Estilo12"><div align="left">
          <% out.println(detalle_peli.getObservaciones()); %>
    </div></span></td>
    </tr>
	
	
	
</table></td>
</tr>
<tr><td>&nbsp;</td></tr>



</tbody>
</table>

<%
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			%>



<tr>
<td style="background-color: rgb(83, 83, 82); height: 8%;"><img style="width: 186px; height: 27px;" alt="" src="./images/copyright.gif"></td>
</tr>
</tbody>
</table>



</body>
</html>