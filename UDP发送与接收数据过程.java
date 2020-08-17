/*UDP发送数据的步骤
    1.创建发送端的Socket对象(DatagramSocket);
	2.创建一个数据包，并把数据打包;
	3.调用DatagramSocket对象的方法发送数据
	4.关闭发送端
	*/
public class SendDemo{
     public static void main(String[] args)throws IOException{
   //创建发送端的Socket对象(DatagramSocket)
   //DatagramSocket()构造数据报套接字并将其绑定到本地主机上的任何可用端口
  
       DatagramSocket ds=new DatagramSocket();
   
   //创建一个数据包，并把数据打包
   //DatagramPacket(byte[] buf,int length,InetAddress address,int port)
   //构造一个数据包，发送长度为length的数据包到指定主机上的指定端口号。
    
	    byte[] bys="hello,udp,我来了".getByte();
        int len=bys.length;
        InetAddress address=InetAddress.getByname("192.168.101.13");
        DatagramPacket dp=new DatagramPacket(bys,length,address,port);
   
   //调用DatagramSocket对象的方法发送数据
   
      ds.send(dp);
   
   //关闭发送端
	ds.close;
	}
}

-----------------------------------------------------------------------------------------------------------------
/*UDP接受数据的步骤
    1.创建接收端的Socket对象(DatagramSocket);
	2.创建一个数据包，用于接收数据(DatagramPacket(byte[] buf,int length));
	3.调用DatagramSocket对象的方法接收数据
	4.解析数据包，并把数据在控制台显示
	5.关闭接收端
	*/
	
public class ReceiveDemo{
  public static void main(String[] args)throws IOException{
   //创建接收端的Socket对象(DatagramSocket)
   //DatagramSocket(int port)构造数据包套接字并将其绑定到本地主机上的指定端口
      DatagramSocket ds=new DatagramSocket(10086);
   
   //创建一个数据包，用于接收数据
   //DatagramPacket(byte[] buf,int length)构造一个DatagramPacket用于接收长度为length数据包
        
		byte[] bys=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bys,bys.length);
   
   //调用DatagramSocket对象的方法接收数据
       
	   ds.receive(dp);
   
   //解析数据包，并把数据在控制台显示
    //byte[] getData()返回数据缓冲区
	   
	   byte[] datas=dp.getData
	
	//int getlength()返回发送的数据的长度或接收到的数据的长度
	   
	   int len =dp.getlength();
	   String dataString=new String(datas,0.len);
	   System.ou.println("数据是："+dataString);
	   ds.close;
	}
}