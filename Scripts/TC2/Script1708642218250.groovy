import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.entity.ContentType

/**
 * This Test Case downloads the Google logo image and save it into a local file.
 * 
 * This script uses the Apache HttpClient library. In the `.classpath` file of this project, I found a line:
 *     /Applications/Katalon Studio.app/Contents/Eclipse/plugins/org.apache.httpcomponents.httpclient_4.5.14.v20221207-1049.jar"/>
 *
 * This means that Katalon Studio bundles the Apache HttpComponet/HttpClient 4.5,
 * so I can use it in this project without any setup
 * 
 * I wrote this code referring to a Baeldung article:
 *     [Apache HttpClient Cookbook](https://www.baeldung.com/apache-httpclient-cookbook)
 */

String url = "https://www.google.co.jp/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"

CloseableHttpClient client = HttpClientBuilder.create().build();
CloseableHttpResponse response = client.execute(new HttpGet(url));
assert response.getStatusLine().getStatusCode() == 200

String contentMimeType = ContentType.getOrDefault(response.getEntity()).getMimeType()
assert contentMimeType == ContentType.IMAGE_PNG.toString()