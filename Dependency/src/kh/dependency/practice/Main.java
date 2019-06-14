package kh.dependency.practice;

import kh.dependency.factory.TvFactory;
import kh.dependency.interfaces.Tv;
import kh.dependency.items.LgTV;

public class Main {
	public static void main(String[] args) {

		//		SamsungTV tv = new SamsungTV();
		//		tv.powerOn();
		//		tv.getModel();
		//		tv.getPrice();
		
		//ó������ �ＺTV ���ٰ� lgTV�� �ٲ���...

//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.getModel();
//		tv.getPrice();
		
		//interface Tv������ LgTV�� powerOn() �ϱ�
		Tv tv = new LgTV();
		tv.powerOn();
		
		//������ ������ ���丮 ����
		//new �ν��Ͻ� ������ ���ϰԵ�����, tv brand�� ����ȴٸ� �ڵ������ �ʿ��ϴ�.
		Tv tv1 = TvFactory.getInstane("lg");
		tv1.powerOn();
		
		//����ؾ� �ڵ�������� ���Ҽ��ִ���...???
		//�������� tv�� brand�� �������� �ڵ�󿡼� ����ϸ� �ȵȴ�..? 
		//�ڵ忡 ���¼��� �̹� �������� ������̴�. 
		
		//ù��°����) �������ϴ� tv�� ������ main�� ���ڰ����� �޾ƿ���..
		//main�� �Ű����� -> �����ų���ѱ�� ���ڰ�.. 
		String selectedTvBrand = args[0];
		Tv tv2 = TvFactory.getInstane(selectedTvBrand);
		tv2.powerOn();
		//�� ����� �ڼ��� ������ ��ƴ�. samsungTv ���� �Է��ϴ°ǵ����� , ������ ���̰�.. �̷� �������λ����� �����ϱ� ��ƴ�.
		//�׸��� �������� �ν��Ͻ��� �������ϰ��... 
		
		//�׷��� �����������ӿ�ũ�� �̿��� xml���Ͽ� resource�� �����ؼ� �ҷ��´�.

		//��������� java perspective �� ������
		
		// -> spring perspective �� ��ȯ�ϱ�

	}
}
