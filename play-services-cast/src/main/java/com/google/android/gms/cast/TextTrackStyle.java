// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.view.accessibility.CaptioningManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.microg.gms.common.Objects;

public final class TextTrackStyle
{

    public TextTrackStyle()
    {
        clear();
    }

    public void setFontScale(float fontScale)
    {
        this.fontScale = fontScale;
    }

    public float getFontScale()
    {
        return fontScale;
    }

    public void setForegroundColor(int foregroundColor)
    {
        this.foregroundColor = foregroundColor;
    }

    public int getForegroundColor()
    {
        return foregroundColor;
    }

    public void setBackgroundColor(int backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor()
    {
        return backgroundColor;
    }

    public void setEdgeType(int edgeType)
    {
        if(edgeType < 0 || edgeType > 4)
        {
            throw new IllegalArgumentException("invalid edgeType");
        } else
        {
            this.edgeType = edgeType;
            return;
        }
    }

    public int getEdgeType()
    {
        return edgeType;
    }

    public void setEdgeColor(int edgeColor)
    {
        this.edgeColor = edgeColor;
    }

    public int getEdgeColor()
    {
        return edgeColor;
    }

    public void setWindowType(int windowType)
    {
        if(windowType < 0 || windowType > 2)
        {
            throw new IllegalArgumentException("invalid windowType");
        } else
        {
            this.windowType = windowType;
            return;
        }
    }

    public int getWindowType()
    {
        return windowType;
    }

    public void setWindowColor(int windowColor)
    {
        this.windowColor = windowColor;
    }

    public int getWindowColor()
    {
        return windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius)
    {
        if(windowCornerRadius < 0)
        {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        } else
        {
            this.windowCornerRadius = windowCornerRadius;
            return;
        }
    }

    public int getWindowCornerRadius()
    {
        return windowCornerRadius;
    }

    public void setFontFamily(String fontFamily)
    {
        this.fontFamily = fontFamily;
    }

    public String getFontFamily()
    {
        return fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily)
    {
        if(fontGenericFamily < 0 || fontGenericFamily > 6)
        {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        } else
        {
            this.fontGenericFamily = fontGenericFamily;
            return;
        }
    }

    public int getFontGenericFamily()
    {
        return fontGenericFamily;
    }

    public void setFontStyle(int fontStyle)
    {
        if(fontStyle < 0 || fontStyle > 3)
        {
            throw new IllegalArgumentException("invalid fontStyle");
        } else
        {
            this.fontStyle = fontStyle;
            return;
        }
    }

    public int getFontStyle()
    {
        return fontStyle;
    }

    public void setCustomData(JSONObject customData)
    {
        this.customData = customData;
    }

    public JSONObject getCustomData()
    {
        return customData;
    }

    private void clear()
    {
        fontScale = 1.0F;
        foregroundColor = 0;
        backgroundColor = 0;
        edgeType = -1;
        edgeColor = 0;
        windowType = -1;
        windowColor = 0;
        windowCornerRadius = 0;
        fontFamily = null;
        fontGenericFamily = -1;
        fontStyle = -1;
        customData = null;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static TextTrackStyle fromSystemSettings(Context context)
    {
        TextTrackStyle texttrackstyle = new TextTrackStyle();
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT)
            return texttrackstyle;
        CaptioningManager captioningmanager = (CaptioningManager)context.getSystemService(Context.CAPTIONING_SERVICE);
        texttrackstyle.setFontScale(captioningmanager.getFontScale());
        android.view.accessibility.CaptioningManager.CaptionStyle captionstyle = captioningmanager.getUserStyle();
        texttrackstyle.setBackgroundColor(captionstyle.backgroundColor);
        texttrackstyle.setForegroundColor(captionstyle.foregroundColor);
        switch(captionstyle.edgeType)
        {
        case 1: // '\001'
            texttrackstyle.setEdgeType(1);
            break;

        case 2: // '\002'
            texttrackstyle.setEdgeType(2);
            break;

        case 0: // '\0'
        default:
            texttrackstyle.setEdgeType(0);
            break;
        }
        texttrackstyle.setEdgeColor(captionstyle.edgeColor);
        Typeface typeface = captionstyle.getTypeface();
        if(typeface != null)
        {
            if(Typeface.MONOSPACE.equals(typeface))
                texttrackstyle.setFontGenericFamily(1);
            else
            if(Typeface.SANS_SERIF.equals(typeface))
                texttrackstyle.setFontGenericFamily(0);
            else
            if(Typeface.SERIF.equals(typeface))
                texttrackstyle.setFontGenericFamily(2);
            else
                texttrackstyle.setFontGenericFamily(0);
            boolean flag = typeface.isBold();
            boolean flag1 = typeface.isItalic();
            if(flag && flag1)
                texttrackstyle.setFontStyle(3);
            else
            if(flag)
                texttrackstyle.setFontStyle(1);
            else
            if(flag1)
                texttrackstyle.setFontStyle(2);
            else
                texttrackstyle.setFontStyle(0);
        }
        return texttrackstyle;
    }

    public void zzd(JSONObject jsonobject)
        throws JSONException
    {
        clear();
        fontScale = (float)jsonobject.optDouble("fontScale", 1.0D);
        foregroundColor = toColor(jsonobject.optString("foregroundColor"));
        backgroundColor = toColor(jsonobject.optString("backgroundColor"));
        if(jsonobject.has("edgeType"))
        {
            String s = jsonobject.getString("edgeType");
            if("NONE".equals(s))
                edgeType = 0;
            else
            if("OUTLINE".equals(s))
                edgeType = 1;
            else
            if("DROP_SHADOW".equals(s))
                edgeType = 2;
            else
            if("RAISED".equals(s))
                edgeType = 3;
            else
            if("DEPRESSED".equals(s))
                edgeType = 4;
        }
        edgeColor = toColor(jsonobject.optString("edgeColor"));
        if(jsonobject.has("windowType"))
        {
            String s1 = jsonobject.getString("windowType");
            if("NONE".equals(s1))
                windowType = 0;
            else
            if("NORMAL".equals(s1))
                windowType = 1;
            else
            if("ROUNDED_CORNERS".equals(s1))
                windowType = 2;
        }
        windowColor = toColor(jsonobject.optString("windowColor"));
        if(windowType == 2)
            windowCornerRadius = jsonobject.optInt("windowRoundedCornerRadius", 0);
        fontFamily = jsonobject.optString("fontFamily", null);
        if(jsonobject.has("fontGenericFamily"))
        {
            String s2 = jsonobject.getString("fontGenericFamily");
            if("SANS_SERIF".equals(s2))
                fontGenericFamily = 0;
            else
            if("MONOSPACED_SANS_SERIF".equals(s2))
                fontGenericFamily = 1;
            else
            if("SERIF".equals(s2))
                fontGenericFamily = 2;
            else
            if("MONOSPACED_SERIF".equals(s2))
                fontGenericFamily = 3;
            else
            if("CASUAL".equals(s2))
                fontGenericFamily = 4;
            else
            if("CURSIVE".equals(s2))
                fontGenericFamily = 5;
            else
            if("SMALL_CAPITALS".equals(s2))
                fontGenericFamily = 6;
        }
        if(jsonobject.has("fontStyle"))
        {
            String s3 = jsonobject.getString("fontStyle");
            if("NORMAL".equals(s3))
                fontStyle = 0;
            else
            if("BOLD".equals(s3))
                fontStyle = 1;
            else
            if("ITALIC".equals(s3))
                fontStyle = 2;
            else
            if("BOLD_ITALIC".equals(s3))
                fontStyle = 3;
        }
        customData = jsonobject.optJSONObject("customData");
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("fontScale", fontScale);
            if(foregroundColor != 0)
                jsonobject.put("foregroundColor", zzy(foregroundColor));
            if(backgroundColor != 0)
                jsonobject.put("backgroundColor", zzy(backgroundColor));
            switch(edgeType)
            {
            case 0: // '\0'
                jsonobject.put("edgeType", "NONE");
                break;

            case 1: // '\001'
                jsonobject.put("edgeType", "OUTLINE");
                break;

            case 2: // '\002'
                jsonobject.put("edgeType", "DROP_SHADOW");
                break;

            case 3: // '\003'
                jsonobject.put("edgeType", "RAISED");
                break;

            case 4: // '\004'
                jsonobject.put("edgeType", "DEPRESSED");
                break;
            }
            if(edgeColor != 0)
                jsonobject.put("edgeColor", zzy(edgeColor));
            switch(windowType)
            {
            case 0: // '\0'
                jsonobject.put("windowType", "NONE");
                break;

            case 1: // '\001'
                jsonobject.put("windowType", "NORMAL");
                break;

            case 2: // '\002'
                jsonobject.put("windowType", "ROUNDED_CORNERS");
                break;
            }
            if(windowColor != 0)
                jsonobject.put("windowColor", zzy(windowColor));
            if(windowType == 2)
                jsonobject.put("windowRoundedCornerRadius", windowCornerRadius);
            if(fontFamily != null)
                jsonobject.put("fontFamily", fontFamily);
            switch(fontGenericFamily)
            {
            case 0: // '\0'
                jsonobject.put("fontGenericFamily", "SANS_SERIF");
                break;

            case 1: // '\001'
                jsonobject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                break;

            case 2: // '\002'
                jsonobject.put("fontGenericFamily", "SERIF");
                break;

            case 3: // '\003'
                jsonobject.put("fontGenericFamily", "MONOSPACED_SERIF");
                break;

            case 4: // '\004'
                jsonobject.put("fontGenericFamily", "CASUAL");
                break;

            case 5: // '\005'
                jsonobject.put("fontGenericFamily", "CURSIVE");
                break;

            case 6: // '\006'
                jsonobject.put("fontGenericFamily", "SMALL_CAPITALS");
                break;
            }
            switch(fontStyle)
            {
            case 0: // '\0'
                jsonobject.put("fontStyle", "NORMAL");
                break;

            case 1: // '\001'
                jsonobject.put("fontStyle", "BOLD");
                break;

            case 2: // '\002'
                jsonobject.put("fontStyle", "ITALIC");
                break;

            case 3: // '\003'
                jsonobject.put("fontStyle", "BOLD_ITALIC");
                break;
            }
            if(customData != null)
                jsonobject.put("customData", customData);
        }
        catch(JSONException jsonexception) { }
        return jsonobject;
    }

    private String zzy(int i)
    {
        return String.format("#%02X%02X%02X%02X", Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i));
    }

    private int toColor(String color) {
        if(color != null && color.length() == 9 && color.charAt(0) == 35) {
            try {
                int var2 = Integer.parseInt(color.substring(1, 3), 16);
                int var3 = Integer.parseInt(color.substring(3, 5), 16);
                int var4 = Integer.parseInt(color.substring(5, 7), 16);
                int var5 = Integer.parseInt(color.substring(7, 9), 16);
                return Color.argb(var5, var2, var3, var4);
            } catch (NumberFormatException var6) {
                // ignore
            }
        }
        return 0;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(!(other instanceof TextTrackStyle))
            return false;
        TextTrackStyle texttrackstyle = (TextTrackStyle)other;
        if((customData == null) != (texttrackstyle.customData == null))
            return false;
        if(customData != null && texttrackstyle.customData != null && !Objects.jsonEquals(customData, texttrackstyle.customData))
            return false;
        else
            return fontScale == texttrackstyle.fontScale && foregroundColor == texttrackstyle.foregroundColor && backgroundColor == texttrackstyle.backgroundColor && edgeType == texttrackstyle.edgeType && edgeColor == texttrackstyle.edgeColor && windowType == texttrackstyle.windowType && windowCornerRadius == texttrackstyle.windowCornerRadius && Objects.equals(fontFamily, texttrackstyle.fontFamily) && fontGenericFamily == texttrackstyle.fontGenericFamily && fontStyle == texttrackstyle.fontStyle;
    }

    public int hashCode()
    {
        return Objects.hash(fontScale, foregroundColor, backgroundColor, edgeType, edgeColor, windowType, windowColor, windowCornerRadius, fontFamily, fontGenericFamily, fontStyle, customData);
    }

    public static final float DEFAULT_FONT_SCALE = 1F;
    public static final int COLOR_UNSPECIFIED = 0;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    private float fontScale;
    private int foregroundColor;
    private int backgroundColor;
    private int edgeType;
    private int edgeColor;
    private int windowType;
    private int windowColor;
    private int windowCornerRadius;
    private String fontFamily;
    private int fontGenericFamily;
    private int fontStyle;
    private JSONObject customData;
}
