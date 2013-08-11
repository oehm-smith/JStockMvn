/*
 * JStock - Free Stock Market Software
 * Copyright (C) 2011 Yan Cheng CHEOK <yccheok@yahoo.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.yccheok.jstock.network;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

/**
 * This class is an utility for network related activities.
 * @author yccheok
 */
public class Utils {
    public enum Type {
        NEWS_INFORMATION_TXT,
        CHAT_SERVER_TXT,
        NTP_SERVER_TXT,
        VERSION_INFORMATION_TXT,
        CURRENCY_CODE_TXT,
        MODULE_INDICATOR_DOWNLOAD_MANAGER_XML,
        ALERT_INDICATOR_DOWNLOAD_MANAGER_XML,
        HELP_STOCK_DATABASE_HTML,
        PRIVACY_HTML,
        HELP_HTML,
        MA_INDICATOR_HTML,
        GET_TIME,
        OPTIONS,
        DONATE_HTML,
        CONTRIBUTE_HTML,
        HELP_KEYBOARD_SHORTCUTS_HTML,
        ANDROID_HTML
    }

    private Utils() {
    }

    /**
     * URL based on current locale language.
     * @param type The URL type
     * @return URL based on current locale language
     */
    public static String getURL(Type type) {
        final Locale defaultLocale = Locale.getDefault();
        if (org.yccheok.jstock.gui.Utils.isSimplifiedChinese(defaultLocale)) {
            return zh_map.get(type);
        }
        return map.get(type);
    }

    /**
     * @return the JStock static server URL
     */
    public static String getJStockStaticServer() {
        return JSTOCK_STATIC_SERVER;
    }
    
    private static final Map<Type, String> map = new EnumMap<Type, String>(Type.class);
    private static final Map<Type, String> zh_map = new EnumMap<Type, String>(Type.class);
    private static final String JSTOCK_STATIC_SERVER = "http://jstock-static.appspot.com/";
    private static final String JSTOCK_WEBAPP_SERVER = "http://jstock-webapp.appspot.com/";

    static {
        map.put(Type.CHAT_SERVER_TXT, JSTOCK_STATIC_SERVER + "servers_information/chat_server.txt");
        map.put(Type.NTP_SERVER_TXT, JSTOCK_STATIC_SERVER + "servers_information/ntp_server.txt");
        map.put(Type.NEWS_INFORMATION_TXT, JSTOCK_STATIC_SERVER + "news_information/index.txt");
        map.put(Type.VERSION_INFORMATION_TXT, JSTOCK_STATIC_SERVER + "version_information/index.txt");
        map.put(Type.CURRENCY_CODE_TXT, JSTOCK_STATIC_SERVER + "currency_information/currency_code.txt");
        map.put(Type.MODULE_INDICATOR_DOWNLOAD_MANAGER_XML, JSTOCK_STATIC_SERVER + "module_indicators/indicator_download_manager.xml");
        map.put(Type.ALERT_INDICATOR_DOWNLOAD_MANAGER_XML, JSTOCK_STATIC_SERVER + "alert_indicators/indicator_download_manager.xml");
        map.put(Type.HELP_STOCK_DATABASE_HTML, "http://jstock.sourceforge.net/help_stock_database.html?utm_source=jstock&utm_medium=database_dialog");
        map.put(Type.PRIVACY_HTML, "http://jstock.sourceforge.net/privacy.html");
        map.put(Type.HELP_HTML, "http://jstock.sourceforge.net/help.html?utm_source=jstock&utm_medium=help_menu");
        map.put(Type.MA_INDICATOR_HTML, "http://jstock.sourceforge.net/ma_indicator.html?utm_source=jstock&utm_medium=chart_dialog");
        map.put(Type.GET_TIME, JSTOCK_WEBAPP_SERVER + "get-time.py");
        map.put(Type.OPTIONS, JSTOCK_STATIC_SERVER + "options_information/options.txt");
        map.put(Type.DONATE_HTML,"http://jstock.sourceforge.net/donation.html?utm_source=jstock&utm_medium=help_menu");
        // http://webmasters.stackexchange.com/questions/35413/unable-to-use-anchor-hash-tag-if-using-google-analytics-utm
        map.put(Type.CONTRIBUTE_HTML, "http://jstock.sourceforge.net/help_faq.html?utm_source=jstock&utm_medium=help_menu#contribution");
        map.put(Type.HELP_KEYBOARD_SHORTCUTS_HTML, "http://jstock.sourceforge.net/help_faq.html?utm_source=jstock&utm_medium=help_menu#keyboard-shortcuts");
        map.put(Type.ANDROID_HTML, "http://www.jstock.co/index.html?utm_source=jstock&utm_medium=android_menu");
        
        zh_map.put(Type.CHAT_SERVER_TXT, JSTOCK_STATIC_SERVER + "servers_information/chat_server.txt");
        zh_map.put(Type.NTP_SERVER_TXT, JSTOCK_STATIC_SERVER + "servers_information/ntp_server.txt");
        zh_map.put(Type.NEWS_INFORMATION_TXT, JSTOCK_STATIC_SERVER + "news_information/zh/index.txt");
        zh_map.put(Type.VERSION_INFORMATION_TXT, JSTOCK_STATIC_SERVER + "version_information/zh/index.txt");
        zh_map.put(Type.CURRENCY_CODE_TXT, JSTOCK_STATIC_SERVER + "currency_information/currency_code.txt");
        zh_map.put(Type.MODULE_INDICATOR_DOWNLOAD_MANAGER_XML, JSTOCK_STATIC_SERVER + "module_indicators/zh/indicator_download_manager.xml");
        zh_map.put(Type.ALERT_INDICATOR_DOWNLOAD_MANAGER_XML, JSTOCK_STATIC_SERVER + "alert_indicators/zh/indicator_download_manager.xml");
        zh_map.put(Type.HELP_STOCK_DATABASE_HTML, "http://jstock.sourceforge.net/zh/help_stock_database.html?utm_source=jstock&utm_medium=database_dialog");
        zh_map.put(Type.PRIVACY_HTML, "http://jstock.sourceforge.net/zh/privacy.html");
        zh_map.put(Type.HELP_HTML, "http://jstock.sourceforge.net/zh/help.html?utm_source=jstock&utm_medium=help_menu");
        zh_map.put(Type.MA_INDICATOR_HTML, "http://jstock.sourceforge.net/zh/ma_indicator.html?utm_source=jstock&utm_medium=chart_dialog");
        zh_map.put(Type.GET_TIME, JSTOCK_WEBAPP_SERVER + "get-time.py");
        zh_map.put(Type.OPTIONS, JSTOCK_STATIC_SERVER + "options_information/options.txt");
        zh_map.put(Type.DONATE_HTML,"http://jstock.sourceforge.net/zh/donation.html?utm_source=jstock&utm_medium=help_menu");
        // http://webmasters.stackexchange.com/questions/35413/unable-to-use-anchor-hash-tag-if-using-google-analytics-utm
        zh_map.put(Type.CONTRIBUTE_HTML, "http://jstock.sourceforge.net/zh/help_faq.html?utm_source=jstock&utm_medium=help_menu#contribution");
        zh_map.put(Type.HELP_KEYBOARD_SHORTCUTS_HTML, "http://jstock.sourceforge.net/zh/help_faq.html?utm_source=jstock&utm_medium=help_menu#keyboard-shortcuts");
        zh_map.put(Type.ANDROID_HTML, "http://www.jstock.co/zh/index.html?utm_source=jstock&utm_medium=android_menu");

        assert(map.size() == Type.values().length);
        assert(zh_map.size() == Type.values().length);
    }
}
