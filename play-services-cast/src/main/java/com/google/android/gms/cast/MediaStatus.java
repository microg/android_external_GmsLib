// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import org.json.*;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo

public final class MediaStatus
{
    MediaStatus(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public MediaStatus(JSONObject json)
        throws JSONException
    {
        parseJson(json, 0);
    }

    public long getMediaSessionId()
    {
        return mediaSessionId;
    }

    public int getPlayerState()
    {
        return playerState;
    }

    public int getIdleReason()
    {
        return idleReason;
    }

    public double getPlaybackRate()
    {
        return playbackRate;
    }

    public MediaInfo getMediaInfo()
    {
        return mediaInfo;
    }

    public long getStreamPosition()
    {
        return streamPosition;
    }

    public boolean isMediaCommandSupported(long mediaCommand)
    {
        return (supportedMediaCommands & mediaCommand) != 0L;
    }

    public double getStreamVolume()
    {
        return streamVolume;
    }

    public boolean isMute()
    {
        return mute;
    }

    public long[] getActiveTrackIds()
    {
        return activeTrackIds;
    }

    public JSONObject getCustomData()
    {
        return customData;
    }

    private int parseJson(JSONObject jsonobject, int i)
        throws JSONException
    {
        int j = 0;
        long l = jsonobject.getLong("mediaSessionId");
        if(l != mediaSessionId)
        {
            mediaSessionId = l;
            j |= 1;
        }
        if(jsonobject.has("playerState"))
        {
            int k = 0;
            String s = jsonobject.getString("playerState");
            if(s.equals("IDLE"))
                k = 1;
            else
            if(s.equals("PLAYING"))
                k = 2;
            else
            if(s.equals("PAUSED"))
                k = 3;
            else
            if(s.equals("BUFFERING"))
                k = 4;
            if(k != playerState)
            {
                playerState = k;
                j |= 2;
            }
            if(k == 1 && jsonobject.has("idleReason"))
            {
                int i1 = 0;
                String s1 = jsonobject.getString("idleReason");
                if(s1.equals("CANCELLED"))
                    i1 = 2;
                else
                if(s1.equals("INTERRUPTED"))
                    i1 = 3;
                else
                if(s1.equals("FINISHED"))
                    i1 = 1;
                else
                if(s1.equals("ERROR"))
                    i1 = 4;
                if(i1 != idleReason)
                {
                    idleReason = i1;
                    j |= 2;
                }
            }
        }
        if(jsonobject.has("playbackRate"))
        {
            double d = jsonobject.getDouble("playbackRate");
            if(playbackRate != d)
            {
                playbackRate = d;
                j |= 2;
            }
        }
        if(jsonobject.has("currentTime") && (i & 2) == 0)
        {
            long l1 = MediaInfo.secondsToMillis(jsonobject.getDouble("currentTime"));
            if(l1 != streamPosition)
            {
                streamPosition = l1;
                j |= 2;
            }
        }
        if(jsonobject.has("supportedMediaCommands"))
        {
            long l2 = jsonobject.getLong("supportedMediaCommands");
            if(l2 != supportedMediaCommands)
            {
                supportedMediaCommands = l2;
                j |= 2;
            }
        }
        if(jsonobject.has("volume") && (i & 1) == 0)
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("volume");
            double d1 = jsonobject1.getDouble("level");
            if(d1 != streamVolume)
            {
                streamVolume = d1;
                j |= 2;
            }
            boolean flag1 = jsonobject1.getBoolean("muted");
            if(flag1 != mute)
            {
                mute = flag1;
                j |= 2;
            }
        }
        boolean flag = false;
        long al[] = null;
        if(jsonobject.has("activeTrackIds"))
        {
            JSONArray jsonarray = jsonobject.getJSONArray("activeTrackIds");
            int j1 = jsonarray.length();
            al = new long[j1];
            for(int k1 = 0; k1 < j1; k1++)
                al[k1] = jsonarray.getLong(k1);

            if(activeTrackIds == null)
                flag = true;
            else
            if(activeTrackIds.length != j1)
            {
                flag = true;
            } else
            {
                int i2 = 0;
                do
                {
                    if(i2 >= j1)
                        break;
                    if(activeTrackIds[i2] != al[i2])
                    {
                        flag = true;
                        break;
                    }
                    i2++;
                } while(true);
            }
            if(flag)
                activeTrackIds = al;
        } else
        if(activeTrackIds != null)
            flag = true;
        if(flag)
        {
            activeTrackIds = al;
            j |= 2;
        }
        if(jsonobject.has("customData"))
        {
            customData = jsonobject.getJSONObject("customData");
            j |= 2;
        }
        if(jsonobject.has("media"))
        {
            JSONObject jsonobject2 = jsonobject.getJSONObject("media");
            mediaInfo = new MediaInfo(jsonobject2);
            j |= 2;
            if(jsonobject2.has("metadata"))
                j |= 4;
        }
        return j;
    }

    public static final long COMMAND_PAUSE = 1L;
    public static final long COMMAND_SEEK = 2L;
    public static final long COMMAND_SET_VOLUME = 4L;
    public static final long COMMAND_TOGGLE_MUTE = 8L;
    public static final long COMMAND_SKIP_FORWARD = 16L;
    public static final long COMMAND_SKIP_BACKWARD = 32L;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int IDLE_REASON_NONE = 0;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_ERROR = 4;
    private long mediaSessionId;
    private MediaInfo mediaInfo;
    private double playbackRate;
    private int playerState;
    private int idleReason;
    private long streamPosition;
    private long supportedMediaCommands;
    private double streamVolume;
    private boolean mute;
    private long activeTrackIds[];
    private JSONObject customData;
}
