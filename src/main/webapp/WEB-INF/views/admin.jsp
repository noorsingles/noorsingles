<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        
        <h1>Welcome Admin</h1>
        
        <form action="datatable#/profileByEmail">
           Search for Email  <input type="text" name="email">
            <input type="submit">
        </form>
         <form action="api/getPrivateProfile">
            Search for ID  <input type="text" name="id">
            <input type="submit">
        </form>
    </body>
</html>
