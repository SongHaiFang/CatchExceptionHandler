package demo.song.com.mymvp;

import android.app.Application;
import android.util.Log;


public class BaseApplication extends Application {
    public static BaseApplication instance;


    public static BaseApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        FileUtils.CreateDir();//创建错误日志文件夹
        if (CrashConfig.HAVE_LOG) {
            CrashHandler crashHandler = CrashHandler.getInstance();
            crashHandler.init(this.getApplicationContext());
        }
        boolean b = FileUtils.checkFilePathExists(FileUtils.SDPATH);
        StringBuffer buffer = new StringBuffer();
        buffer.append("是否会生成错误日志："+(CrashConfig.HAVE_LOG+""))
                .append("\n\n")
                .append("当前编译模式：")
                .append(BuildConfig.DEBUG ? "debug模式" : "release模式")
                .append("\n\n")
                .append("存放错误日志文件夹是否存在：" + b)
                .append("\n\n")
                .append("存放错误日志文件夹物理路径：")
                .append("\n\n")
                .append(FileUtils.file.getAbsolutePath());
        Log.e("Tag","==============="+buffer.toString());
    }
}
