# mimi小模块
<p>
1.原技术是由ssm+jsp 实现，为将自己所学有一个整合用了：springboot+mp+redis+zookeeper+dubbo+thymeleaf等框架服务实现，功能几乎达到完全一致的效果，由于初学初整合有大多代码有点绕，原因是因为thymeleaf页面，ajax和controller之间的运用配合没有过多接触导致有点绕。
  </p><br/>
2.上传图片由于springboot的tomcat是内置，所以request.getServletContext().getRealPath("/")找不到服务器项目的地址，不能即时回显也找不到，暂System.getProperty("user.dir")解决，弹窗时，点一下idea工具栏，再回到页面点击确定就能即刻回显照片。如运行到外置tomcat或打包war，把注释代码改了即可
