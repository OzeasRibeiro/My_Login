<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Detalhes do Cliente</h1>
<br> 
<form action = "/MyLogin/AlterarClienteServlet" method = "post"> 
Id:<input type ="text" id="id" name ="id" value ="${cliente.id}" readonly= "readonly"/> <p>
nome:<input type ="text" id="nome" name ="nome" value ="${cliente.nome}"/> <p>
cpf:<input type ="text" id="cpf" name ="cpf" value ="${cliente.cpf}"/> <p>
email:<input type ="text" id="email" name ="email" value ="${cliente.email}"/> <p>
senha:<input type ="text" id="senha" name ="senha" value ="${cliente.senha}"/> <p>
<input type = "submit" id = "alterar" value = "Alterar"/>

</form>


</body>
</html>