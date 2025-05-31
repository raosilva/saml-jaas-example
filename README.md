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

<security-domain name="saml-jaas" cache-type="default">
    <authentication>
        <login-module code="org.picketlink.identity.federation.bindings.jboss.auth.SAML2LoginModule" flag="required">
            <module-option name="roleKey" value="Role"/>
            <module-option name="principalKey" value="Principal"/>
            <module-option name="identityURL" value="https://idp.example.com/idp"/>
            <module-option name="spEntityID" value="urn:jboss:sp"/>
            <module-option name="idpMetadataURL" value="https://idp.example.com/metadata"/>
            <module-option name="strictPostBinding" value="true"/>
        </login-module>

        <login-module code="com.example.security.CustomSAMLLoginModule" flag="optional"/>
    </authentication>
</security-domain>
