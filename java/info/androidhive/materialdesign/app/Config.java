package info.androidhive.materialdesign.app;

public class Config {

	// Our php+mysql server urls
	public static final String URL_UNIVERSITIES = "http://10.0.2.2/courseHandler/universities.php";
	public static final String URL_BANANAS = "http://192.168.1.101/agriculture/v1/bananas";
	public static final String URL_ONIONS = "http://192.168.1.101/agriculture/v1/onions";
	public static final String URL_MAIZE = "http://192.168.1.101/agriculture/v1/maize";
	public static final String URL_SINGLE_CROP = "http://192.168.1.101/agriculture/v1/single_data";
	public static final String URL_SEND = "http://192.168.1.101/agriculture/v1/send_data";
	public static final String URL_EDIT = "http://192.168.1.101/agriculture/v1/update_single_data";
	public static final String URL_DELETE_SINGLE_CROP = "http://192.168.1.101/agriculture/v1/delete_single_data";
	// Server user login url
	public static String URL_LOGIN = "http://10.0.2.2/courseHandler/login.php";
	// Server user register url
	public static String URL_REGISTER = "http://10.0.2.2/courseHandler/register.php";

	// flag to identify whether to show single line
	// or multi line test push notification tray
	public static boolean appendNotificationMessages = true;

	// global topic to receive app wide push notifications
	public static final String TOPIC_GLOBAL = "global";

	// broadcast receiver intent filters
	public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
	public static final String REGISTRATION_COMPLETE = "registrationComplete";
	public static final String PUSH_NOTIFICATION = "pushNotification";

	// type of push messages
	public static final int PUSH_TYPE_CHATROOM = 1;
	public static final int PUSH_TYPE_USER = 2;

	// id to handle the notification in the notification try
	public static final int NOTIFICATION_ID = 100;
	public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

}
