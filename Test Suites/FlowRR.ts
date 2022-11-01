<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description>Flow Login sampai ATC</description>
   <name>FlowRR</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>55d550f8-1c86-4872-bddf-97f2c054fbbd</testSuiteGuid>
   <testCaseLink>
      <guid>cef9ce07-d708-423a-aa28-9e9c0d18da10</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/createFileReport</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>11396ef3-e118-45f5-b57e-a333f148088a</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/Login and Auth</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>a194afea-2a4b-4977-9e0c-d255adc89933</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/listSKU/listLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>a194afea-2a4b-4977-9e0c-d255adc89933</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Nomor</value>
         <variableId>ce98950e-66de-4f2c-9380-9f78b4768704</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>a194afea-2a4b-4977-9e0c-d255adc89933</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>UID</value>
         <variableId>70d8b055-2563-4210-b298-81c545a8f498</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>a194afea-2a4b-4977-9e0c-d255adc89933</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>06b68748-2910-4289-8fce-446b6173139d</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>0ebde647-2a6e-4794-ba86-9331d6246e03</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/Search/searchPopular</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>a8c20a6d-e352-4178-a6b2-fb705f476594</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/Search/searchTahuSuggestion</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>62155d94-8c7a-4977-8956-b148d09b08b9</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/Search/searchInstant</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>63bced69-a3d6-4925-b6c3-3b7a7e05aa54</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/listSKU/listSKU</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>63bced69-a3d6-4925-b6c3-3b7a7e05aa54</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>skuID</value>
         <variableId>d5cd57eb-2bd4-44d7-a4c5-5fef1893e8eb</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>4a51ad4e-7ab5-4f71-ada2-9afb63664605</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/stock</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>dab13dd2-d6d2-407a-9c75-775063eea94a</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/listSKU/listSKU</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>dab13dd2-d6d2-407a-9c75-775063eea94a</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>skuID</value>
         <variableId>cf06631e-7a46-4644-8112-6fcc1ea12524</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>ab2083c8-2ea8-403e-8896-af305f47ca13</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/minicart</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>541e0e03-5832-4bfe-9e95-044a2c8c2143</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/listSKU/listLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>541e0e03-5832-4bfe-9e95-044a2c8c2143</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>UID</value>
         <variableId>3961132b-4e6c-4fa1-86a5-ecd9213d0731</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>541e0e03-5832-4bfe-9e95-044a2c8c2143</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>5c9ae171-2cf2-4146-ae25-21819f16563f</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
