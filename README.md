# SAML JAAS Example Project

This is a basic example of integrating JBoss EAP 7.3 with SAML 2.0 and JAAS.

## Fictitious parameters used:

- SP URL: http://localhost:8080/saml-jaas-example/
- IdP URL: https://idp.example.com/idp
- IdP Metadata URL: https://idp.example.com/metadata
- SP EntityID: urn:jboss:sp

## Configuration steps:

1. Configure `standalone.xml` with security domain `saml-jaas`.
2. Deploy this WAR to `$JBOSS_HOME/standalone/deployments/`.
3. Configure your IdP with matching SP EntityID and Assertion Consumer Service (ACS) URL.


<login-config>
    <auth-method>BASIC</auth-method>
    <realm-name>ApplicationRealm</realm-name>
</login-config>







<login-config>
    <auth-method>CLIENT-CERT</auth-method> <!-- ou BASIC, DIGEST, etc., mas não FORM -->
    <realm-name>saml-security-domain</realm-name>
</login-config>

<security-constraint>
    <web-resource-collection>
        <web-resource-name>Protected Area</web-resource-name>
        <url-pattern>/protected/*</url-pattern>
    </web-resource-collection>
    <auth-constraint>
        <role-name>user</role-name>
    </auth-constraint>
</security-constraint>







<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirect POST</title>
    <script type="text/javascript">
        window.onload = function() {
            document.forms['postRedirectForm'].submit();
        };
    </script>
</head>
<body>
    <form name="postRedirectForm" method="post" action="destino.jsp">
        <input type="hidden" name="param1" value="<%= request.getParameter("param1") %>">
        <input type="hidden" name="param2" value="<%= request.getParameter("param2") %>">
    </form>
    <p>Redirecionando...</p>
</body>
</html>

