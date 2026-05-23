import manage.PersonManage;
import util.ScannerUtil;
import view.MainMenu;

public class Main {
    static void main() {
        while (true)
        {
            boolean f = false;
            MainMenu.show();
            int num;
            num = ScannerUtil.getMenuChoice("请输入:",0,6);
            switch (num){
                case 0:
                    PersonManage.showPersonAddress();
                    break;
                case 1:
                    PersonManage.selectPerson();
                    break;
                case 2:
                    PersonManage.deletePerson();
                    break;
                case 3:
                    PersonManage.addPerson();
                    break;
                case 4:
                    PersonManage.updatePerson();
                    break;
                case 5:
                    PersonManage.recreateAddress();
                    break;
                case 6:
                    MainMenu.exit();
                    f = true;
                    break;
                default:
                    break;
            }

            if (f)
            {
                break;
            }
        }

        ScannerUtil.close();
    }

}
