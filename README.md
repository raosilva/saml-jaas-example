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
  <auth-method>FORM</auth-method>
  <realm-name>saml-jaas</realm-name>
  <form-login-config>
    <form-login-page>/autoLogin</form-login-page>
    <form-error-page>/error.jsp</form-error-page>
  </form-login-config>
</login-config>

<security-constraint>
  <web-resource-collection>
    <web-resource-name>Protected Area</web-resource-name>
    <url-pattern>/protected/*</url-pattern>
  </web-resource-collection>
  <auth-constraint>
    <role-name>*</role-name>
  </auth-constraint>
</security-constraint>


<%
    response.sendRedirect("j_security_check");
%>


@WebServlet("/autoLogin")
public class AutoLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("j_security_check");
    }
}
