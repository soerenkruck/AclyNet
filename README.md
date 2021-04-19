# AclyNet
An easy Java library for simple networking. Simply send any data.
[Download Library (Jar)](https://github.com/soerenkruck/AclyNet/blob/main/out/artifacts/AclyNet_jar/AclyNet.jar)

## Guiding Principal
Dealing intuitively with data. Build your own Java-based network in few minutes.

```java
DataPackage data = new DataPackage();
data.addData("message", "Hello, world!");

Sender sender = new Sender("127.0.0.1", 2626);
sender.sendDataPackages(data);
```
