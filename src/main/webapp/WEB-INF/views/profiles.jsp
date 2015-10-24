<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML">

<html ng-app='myModule'>
    <head>
        <%@ include file="include/head.jsp" %> 
    </head>
    <body>

        <%@ include file="include/topnav.jsp" %> 
        

        <div class="container" style="" >
            <div ng-view>
                
            </div>

        </div>
        
        <%@ include file="include/footer.jsp" %>        
        <%@ include file="include/scripts.jsp" %> 

    </body>
</html>
