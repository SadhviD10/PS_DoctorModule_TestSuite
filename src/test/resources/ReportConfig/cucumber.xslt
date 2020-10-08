<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Test Case Execution Summary</h2>
                <style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#999;border:none;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#999;color:#444;background-color:#F7FDFA;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#999;color:#fff;background-color:#26ADE4;}
.tg .tg-baqh{text-align:center;vertical-align:top}
.tg .tg-yw4l{vertical-align:top}
.tg .tg-oskr{background-color:#ffffff;vertical-align:top}
.tg .tg-fail{background-color:#ffffff;color:#cb0000;vertical-align:top}
.tg .tg-pass{background-color:#ffffff;color:#32cb00;vertical-align:top}

                  
</style>
                <table class="tg">
                    <tr bgcolor="#9acd32">
                        <th class="tg-baqh">Title</th>
                        <th  class="tg-yw4l">Test Result</th>
                    </tr>
                    <xsl:for-each select="testsuite/testcase">
                        <tr>
                            <td  class="tg-6k2t"><b>
                                <xsl:value-of select="@name"/>
                            </b></td>
                            <xsl:choose>          
                                <xsl:when test="failure">
                                    <td  class="tg-fail" >
                                      <pre><xsl:value-of select="failure"/></pre>
                                    </td>
                                </xsl:when>
                               <xsl:otherwise>
                                    <td class="tg-pass">
                                        <xsl:if test="not(failure)"><pre><xsl:value-of select="system-out"/></pre></xsl:if>
                                    </td>     
                                </xsl:otherwise>
</xsl:choose> 
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet> 

