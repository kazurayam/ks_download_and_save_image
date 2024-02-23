import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * This Test Case tries to download a image of Apple, save it into a local file.
 * This script uses the build-in keywords of Katalon Studio for WebService testing.
 * But this code does not work. I believe I found a bug in Katalon Studio.
 * The bug entertains me. I am a detective of buggy software.
 */

ResponseObject res = WS.sendRequest(findTestObject('Object Repository/AppleImage'))

assert res.getStatusCode() == 200

HttpBodyContent bodyContent = res.getBodyContent()
println "${bodyContent.getContentLength()} bytes"
println "${bodyContent.getContentType()}"
println "${bodyContent.getContentEncoding()}"   // returns null. This must be a bug.

Path file = Paths.get("./google_logo.png")
Files.createDirectories(file.getParent())
OutputStream ostream = new FileOutputStream(file.toFile())

bodyContent.writeTo(ostream)