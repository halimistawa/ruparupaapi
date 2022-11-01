<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>addCart</name>
   <tag></tag>
   <elementGuidId>6c1306ce-f0da-4928-8f4d-d2d5ba2553a6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;device\&quot;: \&quot;desktop\&quot;,\n    \&quot;items\&quot;: [\n        {\n            \&quot;sku\&quot;: \&quot;10179909\&quot;,\n            \&quot;qty_ordered\&quot;: 1,\n            \&quot;is_product_scanned\&quot;: 0\n        },\n        {\n            \&quot;sku\&quot;: \&quot;10408468\&quot;,\n            \&quot;qty_ordered\&quot;: 1,\n            \&quot;is_product_scanned\&quot;: 0\n        }\n    ],\n    \&quot;customer\&quot;: {\n        \&quot;customer_id\&quot;: 1705079,\n        \&quot;customer_is_guest\&quot;: 0\n    },\n    \&quot;device_token\&quot;: \&quot;\&quot;,\n    \&quot;cart_type\&quot;: \&quot;\&quot;,\n    \&quot;remote_ip\&quot;: \&quot;182.16.175.222, 52.74.133.187\&quot;,\n    \&quot;company_code\&quot;: \&quot;ODI\&quot;\n}\n&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <katalonVersion>8.0.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://fakturnew.cart.ruparupastg.my.id/cart/create</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
