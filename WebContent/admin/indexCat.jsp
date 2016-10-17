<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/addCat" class="button">
			<span>Thêm danh mục <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<%
			if(request.getParameter("msg")!=null){
				String msg = request.getParameter("msg");
				if("add1".equals(msg)){
						out.print("<p>Thêm thành công</p>");
						
				}else if("add0".equals(msg)){
						out.print("<p>Có lỗi. Vui lòng thử lại!</p>");
				}
				if("del1".equals(msg)){
					out.print("<p>Thêm thành công</p>");
					
				}else if("del0".equals(msg)){
					out.print("<p>Có lỗi. Vui lòng thử lại!</p>");
				}
			}
		%>

		<h2><span>Danh sách danh mục</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Category> alCat = (ArrayList<Category>)request.getAttribute("alCat");
						for(Category objCat:alCat){
					%>
					<tr>
						<td class="align-center"><%=objCat.getId_cat() %></td>
						<td><a href=""><%=objCat.getName()%></a></td>
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/editCat?cid=<%=objCat.getId_cat() %>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a onclick="return confirm('Bạn có thực sự muốn xóa không?)'" href="<%=request.getContextPath()%>/admin/delCat?cid=<%=objCat.getId_cat()%>">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
					
					<%} %>
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<span>Trang:</span> 
				<a href="">1</a> 
				<span>|</span> 
				<a href="">2</a> 
				<span>|</span> 
				<span class="current">3</span> 
				<span>|</span> 
				<a href="">4</a> 
				<span>|</span> 
				<a href="">5</a> 
				<span>|</span> 
				<a href="">6</a> 
				<span>|</span> 
				<a href="">7</a>
				<span>|</span> 
				<a href="">8</a> 
				<span>|</span> 
				<a href="">9</a>
				<span>|</span> 
				<a href="">10</a>   
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 