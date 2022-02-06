<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
<style>
td, th {
  font-family: arial, sans-serif;
}
</style>
<script type="text/javascript">
    function validate() {
         if (document.forms["user"]["fname"].value == "") {
              alert("Please enter first name");
              document.forms["user"]["fname"].focus();
              return false;
         }
         if (document.forms["user"]["lname"].value == "") {
              alert("Please enter last name");
              document.forms["user"]["lname"].focus();
              return false;
         }
         if (document.forms["user"]["email"].value == "") {
              alert("Please enter email");
              return false;
         }
   }
</script>
</head>
<body style="background-color: #FFFFE0;">
<div style="margin-top:50px; margin-left:250px; height:50px;">
<h2>User <c:out value="${user.uid != null ? 'Update' : 'Registration' }" /></h2></div>
  
  <form:form method="POST" modelAttribute="user" action="/users" name="user">
     <table style="vertical-align: center; margin-left:20%;">
        <tr>
            <td>First Name :</td>
            <td><form:input path="firstName" id="fname" /></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName" id="lname"/></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><form:input path="email" id="email"/></td>
        </tr>
        
        <tr>
            <td>password:</td>
            <td><form:password path="password" id="password"/></td>
        </tr>
        
        <tr>
             <td>Mobile Number :</td>
             <td><form:input path="mobileNumber" /></td>
        </tr>
        <tr>
             <td colspan="2"><input type="submit" value="<c:out value="${user.uid != null ? 'Update' : 'Register' }" />"
             onclick="return validate();">&nbsp;&nbsp; <a href="/users/all">UserList</a>&nbsp;
            <c:if test="${user.uid ne null}"><b>|</b>&nbsp;<a href="users">register</a></c:if>
         </td>
         
          <td colspan="2"><a href="/">home</a></td>
    </tr>
</table>
</form:form>
</body>
</html>
