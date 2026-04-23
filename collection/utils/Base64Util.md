`` 二进制转base64
public String getFileToBase64(String objectName){
try (InputStream inputStream = minioClient.getObject(
GetObjectArgs.builder()
.bucket(bucketName)
.object(objectName)
.build()))  {
// 1. 将输入流转换为字节数组（Apache Commons IO 工具类，简洁高效）
byte[] fileBytes = IOUtils.toByteArray(inputStream);
// 2. 字节数组编码为 Base64 字符串
return Base64.getEncoder().encodeToString(fileBytes);
} catch (Exception e){
e.printStackTrace();
}
return null;
}
``