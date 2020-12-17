package org.SKOVIGAMES;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.net.URL;

class ConfReader
{
    private static FileInputStream reader;
    private static Properties props = new Properties();

    static //чтение конфига
    {
        try
        {
            reader = new FileInputStream("src/test/resources/conf.properties");
            props.load(reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (reader != null)
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) //строка из конфига
    {
        return props.getProperty(key);
    }

    public static URL getPropertyUrl(String key) throws IOException //ссылка из конфига
    {
            return new URL(props.getProperty(key));
    }
}