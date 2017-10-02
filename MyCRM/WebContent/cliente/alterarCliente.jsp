<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "/MyCRM/AlterarClienteServlet" method = "post"> 

Id:<input type ="text" id="id" name ="id" value ="${cliente.id}" readonly= "readonly"/> <p>
nomeCompleto:<input type ="text" id="nomeCompleto" name ="nomeCompleto" value ="${cliente.nome}"/> <p>
cpf:<input type ="text" id="cpf" name ="cpf" value ="${cliente.cpf}"/> <p>
email:<input type ="text" id="email" name ="email" value ="${cliente.email}"/> <p>
limiteCredito:<input type ="text" id="limiteCredito" name ="limiteCredito" value ="${cliente.senha}"/> <p>

</form>
</body>
</html>