<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>updateCart</name>
   <tag></tag>
   <elementGuidId>9440ae88-dc2f-48d5-9337-98ed0c2190cc</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;data\&quot;: {\n        \&quot;cart_id\&quot;: \&quot;f475f07e18390cf20a1279e3454c1f8853d0e0f1\&quot;,\n        \&quot;device\&quot;: \&quot;desktop\&quot;,\n        \&quot;items\&quot;: [{\n            \&quot;sku\&quot;: \&quot;10179909\&quot;,\n            \&quot;qty_ordered\&quot;: 1,\n            \&quot;shipping\&quot;: {\n                \&quot;pickup\&quot;: {\n                    \&quot;pickup_code\&quot;: \&quot;\&quot;\n                },\n                \&quot;delivery_method\&quot;: \&quot;delivery\&quot;,\n                \&quot;store_code\&quot;: \&quot;\&quot;\n            },\n            \&quot;utm_parameter\&quot;: \&quot;https://fakturnew.www.ruparupastg.my.id/krischef-set-cangkir-espresso-88-ml-merah.html?itm_source\u003dinspiration-red-for-luck\u0026itm_campaign\u003dred-for-luck\u0026itm_term\u003d10179909\u0026itm_device\u003ddesktop\u0026itm_origin\u003dinspiration-red-for-luck\&quot;\n        }],\n        \&quot;device_token\&quot;: \&quot;cruErXEVxpU:APA91bEA9my2NM9eNYDNun8fdoGnPRP6FEwrZvM101gQqMYHAQYQFO8xV-Y_FP00PolAnuCjKsoVqhAh8xsa6klx5Vc2VYk5dwYwPSodzPUwTcqy5BMg9tHXyI6aIw8jOTisuKeoy6iU\&quot;,\n        \&quot;store_code\&quot;: \&quot;\&quot;,\n        \&quot;affiliate_id\&quot;: \&quot;\&quot;\n    }\n}&quot;,
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer </value>
   </httpHeaderProperties>
   <katalonVersion>8.0.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://fakturnew.wapi.ruparupastg.my.id/user/cart/update</restUrl>
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
