// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import android.text.TextUtils;
import org.json.*;
import org.microg.gms.common.Objects;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata, MediaTrack, TextTrackStyle

public final class MediaInfo
{
    public static class Builder
    {

        public Builder setStreamType(int streamType)
            throws IllegalArgumentException
        {
            mediaInfo.setStreamType(streamType);
            return this;
        }

        public Builder setContentType(String contentType)
            throws IllegalArgumentException
        {
            mediaInfo.setContentType(contentType);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata)
        {
            mediaInfo.zza(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration)
            throws IllegalArgumentException
        {
            mediaInfo.zzm(duration);
            return this;
        }

        public Builder setCustomData(JSONObject customData)
        {
            mediaInfo.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List mediaTracks)
        {
            mediaInfo.zzg(mediaTracks);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle)
        {
            mediaInfo.setTextTrackStyle(textTrackStyle);
            return this;
        }

        public MediaInfo build()
            throws IllegalArgumentException
        {
            mediaInfo.zzhi();
            return mediaInfo;
        }

        private final MediaInfo mediaInfo;

        public Builder(String contentId)
            throws IllegalArgumentException
        {
            if(TextUtils.isEmpty(contentId))
            {
                throw new IllegalArgumentException("Content ID cannot be empty");
            } else
            {
                mediaInfo = new MediaInfo(contentId);
                return;
            }
        }
    }


    MediaInfo(String contentId)
        throws IllegalArgumentException
    {
        if(TextUtils.isEmpty(contentId))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            this.contentId = contentId;
            streamType = -1;
            duration = -1L;
            return;
        }
    }

    MediaInfo(JSONObject json)
        throws JSONException
    {
        contentId = json.getString("contentId");
        String s = json.getString("streamType");
        if("NONE".equals(s))
            streamType = 0;
        else
        if("BUFFERED".equals(s))
            streamType = 1;
        else
        if("LIVE".equals(s))
            streamType = 2;
        else
            streamType = -1;
        contentType = json.getString("contentType");
        if(json.has("metadata"))
        {
            JSONObject jsonobject = json.getJSONObject("metadata");
            int i = jsonobject.getInt("metadataType");
            mediaMetadata = new MediaMetadata(i);
            mediaMetadata.zzd(jsonobject);
        }
        duration = -1L;
        if(json.has("duration") && !json.isNull("duration"))
        {
            double d = json.optDouble("duration", 0.0D);
            if(!Double.isNaN(d) && !Double.isInfinite(d))
                duration = secondsToMillis(d);
        }
        if(json.has("tracks"))
        {
            mediaTracks = new ArrayList<>();
            JSONArray jsonarray = json.getJSONArray("tracks");
            for(int j = 0; j < jsonarray.length(); j++)
            {
                JSONObject jsonobject2 = jsonarray.getJSONObject(j);
                MediaTrack mediatrack = new MediaTrack(jsonobject2);
                mediaTracks.add(mediatrack);
            }

        } else
        {
            mediaTracks = null;
        }
        if(json.has("textTrackStyle"))
        {
            JSONObject jsonobject1 = json.getJSONObject("textTrackStyle");
            TextTrackStyle texttrackstyle = new TextTrackStyle();
            texttrackstyle.zzd(jsonobject1);
            textTrackStyle = texttrackstyle;
        } else
        {
            textTrackStyle = null;
        }
        customData = json.optJSONObject("customData");
    }

    public String getContentId()
    {
        return contentId;
    }

    void setStreamType(int streamType)
        throws IllegalArgumentException
    {
        if(streamType < -1 || streamType > 2)
        {
            throw new IllegalArgumentException("invalid stream type");
        } else
        {
            this.streamType = streamType;
            return;
        }
    }

    public int getStreamType()
    {
        return streamType;
    }

    void setContentType(String contentType)
        throws IllegalArgumentException
    {
        if(TextUtils.isEmpty(contentType))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else
        {
            this.contentType = contentType;
            return;
        }
    }

    public String getContentType()
    {
        return contentType;
    }

    void zza(MediaMetadata mediametadata)
    {
        mediaMetadata = mediametadata;
    }

    public MediaMetadata getMetadata()
    {
        return mediaMetadata;
    }

    void zzm(long l)
        throws IllegalArgumentException
    {
        if(l < 0L && l != -1L)
        {
            throw new IllegalArgumentException("Invalid stream duration");
        } else
        {
            duration = l;
            return;
        }
    }

    public long getStreamDuration()
    {
        return duration;
    }

    void zzg(List list)
    {
        mediaTracks = list;
    }

    public List getMediaTracks()
    {
        return mediaTracks;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle)
    {
        this.textTrackStyle = textTrackStyle;
    }

    public TextTrackStyle getTextTrackStyle()
    {
        return textTrackStyle;
    }

    void setCustomData(JSONObject customData)
    {
        this.customData = customData;
    }

    public JSONObject getCustomData()
    {
        return customData;
    }

    void zzhi()
        throws IllegalArgumentException
    {
        if(TextUtils.isEmpty(contentId))
            throw new IllegalArgumentException("content ID cannot be null or empty");
        if(TextUtils.isEmpty(contentType))
            throw new IllegalArgumentException("content type cannot be null or empty");
        if(streamType == -1)
            throw new IllegalArgumentException("a valid stream type must be specified");
        else
            return;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("contentId", contentId);
            String s;
            switch(streamType)
            {
            case 1: // '\001'
                s = "BUFFERED";
                break;

            case 2: // '\002'
                s = "LIVE";
                break;

            case 0: // '\0'
            default:
                s = "NONE";
                break;
            }
            jsonobject.put("streamType", s);
            if(contentType != null)
                jsonobject.put("contentType", contentType);
            if(mediaMetadata != null)
                jsonobject.put("metadata", mediaMetadata.toJson());
            if(duration <= -1L)
                jsonobject.put("duration", JSONObject.NULL);
            else
                jsonobject.put("duration", millisToSeconds(duration));
            if(mediaTracks != null)
            {
                JSONArray jsonarray = new JSONArray();
                for(MediaTrack mediaTrack : mediaTracks)
                    jsonarray.put(mediaTrack.toJson());
                jsonobject.put("tracks", jsonarray);
            }
            if(textTrackStyle != null)
                jsonobject.put("textTrackStyle", textTrackStyle.toJson());
            if(customData != null)
                jsonobject.put("customData", customData);
        }
        catch(JSONException jsonexception) { }
        return jsonobject;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(!(other instanceof MediaInfo))
            return false;
        MediaInfo mediainfo = (MediaInfo)other;
        if((customData == null) != (mediainfo.customData == null))
            return false;
        if(customData != null && mediainfo.customData != null && !Objects.jsonEquals(customData, mediainfo.customData))
            return false;
        else
            return Objects.equals(contentId, mediainfo.contentId) && streamType == mediainfo.streamType && Objects.equals(contentType, mediainfo.contentType) && Objects.equals(mediaMetadata, mediainfo.mediaMetadata) && duration == mediainfo.duration;
    }

    public int hashCode()
    {
        return Objects.hash(contentId, streamType, contentType, mediaMetadata, duration, String.valueOf(customData));
    }

    static long secondsToMillis(double seconds) {
        return (long)(seconds * 1000.0D);
    }

    static double millisToSeconds(long millis) {
        return (double)millis / 1000.0D;
    }

    public static final int STREAM_TYPE_NONE = 0;
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final long UNKNOWN_DURATION = -1L;
    private final String contentId;
    private int streamType;
    private String contentType;
    private MediaMetadata mediaMetadata;
    private long duration;
    private List<MediaTrack> mediaTracks;
    private TextTrackStyle textTrackStyle;
    private JSONObject customData;
}
