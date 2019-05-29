<%@ page import="java.util.*, beans.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script language="JavaScript">
<!--
image0 = new Image();
image0.src = "./images/ordenar.gif";
image1 = new Image();
image1.src = "./images/buscar.gif";
image2 = new Image();
image2.src = "./images/anadir.gif";
image3 = new Image();
image3.src = "./images/inicio.gif";
image4 = new Image();
image4.src = "./images/retoceder.gif";
image5 = new Image();
image5.src = "./images/anterior.gif";
image6 = new Image();
image6.src = "./images/siguiente.gif";


function avisar() {
	javascript:history.back();
	alert('NO HAY MAS PELICULAS!');

	return 0
}

-->
</script>
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

<%
Collection pel =(Collection) request.getAttribute("listado_peliculas");
Iterator i = pel.iterator();

if (!i.hasNext()) { %>

	<script>		
		avisar();		
	</script>
	<%
}

%>
<table id="wrapper" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
<tbody>

<tr>

<td style="text-align: right; height: 9%; width: 90%; background-color: rgb(83, 83, 82);">
  <div align="right"><img src="images/t_listar.gif" alt="" width="200" height="60" align="left" style="width: 200px; height: 60px;">
      <img src="./images/videoteca.gif" alt="" width="614" height="40" align="top" style="width: 250px; height: 40px;"> </div></td>

</tr>

<tr>
<td valign="top" style="height: 79%; width: 100%; background-color: silver;">

  <table width="100%" height="100%" border="0" cellpadding="5" cellspacing="2" 
style="background-color: silver; text-align: left; margin-left: auto; margin-right: auto; width: 100%; height: 100%;">
<tbody>

<tr>
<td width="14%" style="text-align: left;"><a href="Controlador?operacion=opFormBuscarPeliculas" onmouseover="image1.src='./images/buscar_satinado.gif';" onmouseout="image1.src='./images/buscar.gif';"><img src="images/buscar.gif" alt="" name="image1" width="66" height="23" style="border: 0px solid ; width: 66px; height: 23px;"></a>
</td>

<td width="9%" style="text-align: center;">
  <div align="left">
  </div></td>

<td width="22%" style="text-align: center;">
  <div align="left"><a href="Controlador?operacion=opFormAnadirPeliculas" onmouseover="image2.src='./images/anadir_satinado.gif';" onmouseout="image2.src='./images/anadir.gif';"><img src="images/anadir.gif" alt="" name="image2" width="66" height="23" style="border: 0px solid ; width: 66px; height: 23px;"></a>
  </div></td>

<td width="13%" style="text-align: center;"><a href="Controlador?operacion=opFormOrdenarPeliculas" onMouseOver="image0.src='./images/ordenar_satinado.gif';" onMouseOut="image0.src='./images/ordenar.gif';"><img src="images/ordenar.gif" alt="" name="image0" width="81" height="23" style="border: 0px solid ; width: 81px; height: 23px;"></a></td>

<td width="25%" style="text-align: right;">
<a href="Controlador?operacion=opIndex" onmouseover="image3.src='./images/inicio_satinado.gif';" onmouseout="image3.src='./images/inicio.gif';"><img src="images/inicio.gif" alt="" name="image3" width="57" height="23" style="border: 0px solid ; width: 57px; height: 23px;"></a>
</td>

<td width="17%" style="text-align: right;">
<a href="javascript:history.back( )" onmouseover="image4.src='./images/retroceder_satinado.gif';" onmouseout="image4.src='./images/retroceder.gif';"><img src="images/retroceder.gif" alt="" name="image4" width="102" height="23" style="border: 0px solid ; width: 102px; height: 23px;"></a>
</td>

</tr>
 
<tr valign="top">

<td colspan="6" style="text-align: center; background-color: silver;">
<hr>
<table width="100%" border="1" cellpadding="2" cellspacing="0">
    <tr bgcolor="A6B4BF">
      <th width="7%" height="27" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">C&oacute;digo</span></div></th>
      <th width="21%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">T&iacute;tulo</span></div></th>      
      <th width="9%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Director</span></div></th>
      <th width="9%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Actor1</span></div></th>
      <th width="10%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Actor2</span></div></th>
      <th width="10%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Actor3</span></div></th>
      <th width="9%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Ubicaci&oacute;n</span></div></th>
      <th width="7%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Vista?</span></div></th>
      <th width="9%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">G&eacute;nero1</span></div></th>
      <th width="9%" scope="col"><div align="center" class="Estilo16"><span class="Estilo17">Genero2</span></div></th>
    </tr>
    <% try {
				boolean fila_par=false;
				
				Collection peliculas = 
					(Collection) request.getAttribute("listado_peliculas");
				Iterator it = peliculas.iterator();
				
				while (it.hasNext()) {
						
    					ResumenPeliculas res_peli = (ResumenPeliculas) it.next();
    					
				
				if (!fila_par) {
				%>
   				  <tr bgcolor="#D6E7FA" onMouseOver="this.style.backgroundColor='#DFFAC4';" onMouseOut="this.style.backgroundColor='#D6E7FA';">
				<%
				} else {
				%>
				<tr bgcolor="#E8F1FE" onMouseOver="this.style.backgroundColor='#DFFAC4';" onMouseOut="this.style.backgroundColor='#E8F1FE';">			
				<%
				;}
				if (!fila_par)
							fila_par=true;
						else
							fila_par=false;
				%>	
      <td> 
	  <span class="Estilo12">
        <% out.println(res_peli.getIdPelicula()); %>
      </td>
      <td>
        <span class="Estilo13">
         
		<a href="Controlador?operacion=opListarDetallePelicula&id_pelicula=<%= res_peli.getIdPelicula() %>" class="Estilo10 Estilo11">
		<%out.println(res_peli.getTitulo()); %>
		</a>
		<%
		if (!res_peli.getSubtitulo().equals(""))
			out.println(res_peli.getSubtitulo());
		%>
        </span></td>
    
      <td>
        <span class="Estilo12">
        <% out.println(res_peli.getDirector()); %>
        </span></td>
      <td>
        <span class="Estilo12">
        <% out.println(res_peli.getActor1()); %>
        </span></td>
      <td>
        <span class="Estilo12">
        <%	                        
	                        if (res_peli.getActor2().equals(""))
	                        	out.println("");                        	
	                        else
	                        	out.println(res_peli.getActor2());                         	
	                    %>
        </span></td>
      <td>
        <span class="Estilo12">
        <%	                        
	                        if (res_peli.getActor3().equals(""))
	                        	out.println("");                        	
	                        else
	                        	out.println(res_peli.getActor3());                         	
	                    %>
        </span></td>
      <td>
        <span class="Estilo12">
        <% out.println(res_peli.getLocalizacion()); %>
        </span></td>
      <td>
        <span class="Estilo12">
        <%	                        
	                        if (res_peli.getVisualizada().compareTo("0")==0)
	                        	out.println("No");                        	
	                        else
	                        		out.println("Si");                        	
	                    %>
        </span></td>
      <td>
        <span class="Estilo12">
        <% out.println(res_peli.getGenero1()); %>
        </span></td>
      <td>
        <span class="Estilo12">
        <% out.println(res_peli.getGenero2()); %>
        </span></td>
    </tr>
    <%
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			%>
  </table></td>
</tr>

<tr>
<td colspan="6">

<%

int pag_act=Integer.parseInt(request.getAttribute("pagina_actual").toString());

if (pag_act==0) {

%>
		<table width="100%"><tr><td width="100%" align="right">
		<a href="Controlador?operacion=opListarPeliculas&pagina_actual=<%= pag_act+1 %>" 
	onmouseover="image6.src='./images/siguiente_satinado.gif';" 
	onmouseout="image6.src='./images/siguiente.gif';">
		<img src="images/siguiente.gif" alt="" name="image6" width="88" height="26" align="bottom" style="border: 0px solid ; width: 88px; height: 26px;">
	</a> 
</td>
		</tr>
</table>
<%
} else {
%>		
	<table width="100%"><tr><td align="left">
	<a href="Controlador?operacion=opListarPeliculas&pagina_actual=<%= pag_act-1 %>" 
	onmouseover="image5.src='./images/anterior_satinado.gif';" 
	onmouseout="image5.src='./images/anterior.gif';">
	<img src="images/anterior.gif" alt="" name="image5" width="79" height="23" style="border: 0px solid ; width: 79px; height: 23px;">
	</a> 
</td>
<td align="right">
	<a href="Controlador?operacion=opListarPeliculas&pagina_actual=<%= pag_act+1 %>" 
	onmouseover="image6.src='./images/siguiente_satinado.gif';" 
	onmouseout="image6.src='./images/siguiente.gif';">
	<img src="images/siguiente.gif" alt="" name="image6" width="88" height="26" style="border: 0px solid ; width: 88px; height: 26px;">
	</a> 
</td>
</tr>
</table>	
<%
}
%>	
</td>
</tbody>
</table></td>
</tr>

<tr>
<td style="background-color: rgb(83, 83, 82); height: 8%;"><img style="width: 186px; height: 27px;" alt="" src="./images/copyright.gif"></td>
</tr>
</tbody>
</table>
</body></html>
