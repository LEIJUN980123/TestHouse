/*发送数据的步骤
   1.创建客户端的Socket对象(Socket)
   2.获取输出流，写数据
   3.释放资源
   */
   public class ClientDemo{
       public static void main(String[] args)throws IOException{
	      //创建客户端的Socket对象(Socket)
		  //Socket(InetAddress address,int port)创建流套接字并将其连接到指定Ip地址的指定端口号
		   Socket s=new Socket(InetAddress.getByname("192.168.101.13"),10000);//第一种方式
		  //Socket(String host，int port)创建流套接字并将其连接到指定主机的指定端口号
		   Socket s=new Socket("192.168.101.13",10000)//第二种方式
		   
		   //获取输出流，写数据
		   //OutputStream getOutputStream()返回此套接字的输出流
		  OutputStream os=s.getOutputStream
		  os.write("hello,我来了".getBytes());
		  
		  //接收服务端反馈
		  InputStream is=s.getInputStream();
		  byte[] bys=new byte[1024];
		  int len =is.read(bys);
		  String data=new String(bys,o,len);
		  System.out.println("客户端："+data);
		  
		  
		  //释放资源
		  s.close();
	   }
   }
   
   
 /*接收数据的步骤
   1.创建服务端端的Socket对象(ServerSocket)
   2.获取输入流，读数据,并把数据显示在控制台
   3.释放资源
   */
   public class ServerDemo{
	   public static void main(String[] args)throws IOException{
		    //创建服务端端的Socket对象(ServerSocket)
			//ServerSocket(int port)创建绑定到指定端口的服务器套接字
			ServerSocket ss=new ServerSocket(10000);
			//获取输入流，读数据，并把数据显示在控制台
			 Socket s=ss.accept();//监听客户端连接
			 InputStream is=s.getInputStream;
			 byte[] bys=new byte[1024];
			 int len=is.read(bys);
			 String data=new String(bys,0,len);
			 System.out.println("服务器收到数据："+data);
			 //给出反馈78
			 OutputStream os=s.getOutputStream();
			 os.write("数据已经收到".getBytes());
			 
			 s.close;
			 ss.close;
	   }
   }