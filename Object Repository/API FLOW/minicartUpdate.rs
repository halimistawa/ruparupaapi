<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Update Minicart RR</description>
   <name>minicartUpdate</name>
   <tag></tag>
   <elementGuidId>24febc53-8776-47c3-ba34-7f13ed6406c7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;data\&quot;: {\n        \&quot;minicart_id\&quot;:\&quot;${minicartid}\&quot;,\n        \&quot;device\&quot;: \&quot;desktop\&quot;,\n        \&quot;items\&quot;: [{\n            \&quot;sku\&quot;: \&quot;${sku}\&quot;,\n            \&quot;qty_ordered\&quot;: 0,\n            \&quot;qty_increment\&quot;: ${qty},\n            \&quot;shipping\&quot;: {\n                \&quot;pickup\&quot;: {\n                    \&quot;pickup_code\&quot;: \&quot;\&quot;\n                },\n                \&quot;delivery_method\&quot;: \&quot;delivery\&quot;,\n                \&quot;store_code\&quot;: \&quot;\&quot;\n            },\n            \&quot;utm_parameter\&quot;: \&quot;https://tugu.www.ruparupastg.my.id/cart\&quot;,\n            \&quot;is_checked\&quot;: true\n        }\n        ],\n        \&quot;device_token\&quot;: \&quot;\&quot;,\n        \&quot;store_code\&quot;: \&quot;\&quot;,\n        \&quot;affiliate_id\&quot;: \&quot;\&quot;\n    }\n}&quot;,
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
      <value>${authorization}</value>
   </httpHeaderProperties>
   <katalonVersion>7.8.2</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${base_url}/user/cart/minicart/update</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.baseURL</defaultValue>
      <description></description>
      <id>d588a762-5ca7-4904-9e6c-842ac8c9e706</id>
      <masked>false</masked>
      <name>base_url</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.accessToken</defaultValue>
      <description></description>
      <id>94fc8661-073d-43d6-8b83-57520c609199</id>
      <masked>false</masked>
      <name>authorization</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.minicartID</defaultValue>
      <description></description>
      <id>d2b1f73e-8810-4c1a-b66f-7f4f835897b0</id>
      <masked>false</masked>
      <name>minicartid</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.sku</defaultValue>
      <description></description>
      <id>7d91b986-416b-4724-ae3f-d9134234d500</id>
      <masked>false</masked>
      <name>sku</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.qtyafter</defaultValue>
      <description></description>
      <id>7ee6ceb9-f42f-4eb1-8ac1-3b828a6b6375</id>
      <masked>false</masked>
      <name>qty</name>
   </variables>
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
