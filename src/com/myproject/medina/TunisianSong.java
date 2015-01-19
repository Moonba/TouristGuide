package com.myproject.medina;


import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;


public class TunisianSong extends YouTubeBaseActivity 
implements OnInitializedListener {
	public static final String EP1_ID = "0MjZqSBuLc8";
	public static final String EP2_ID = "gbPwGyubZx0";
	public static final String EP3_ID = "BdTj5urB5Ok";
	public static final String EP4_ID = "IaEijaji8M8";
	public static final String EP5_ID = "NSD8PpFxCvc";
	public static final String EP6_ID = "vnPPcSo9NLA";	
	
	ImageButton playButton;
	ImageButton pauseButton;
	
	
	YouTubeThumbnailView ep1View;	
	YouTubeThumbnailView ep2View;	
	YouTubeThumbnailView ep3View;
	YouTubeThumbnailView ep4View;	
	YouTubeThumbnailView ep5View;	
	YouTubeThumbnailView ep6View;
	
	ThumbnailListener thumbListner;
	
	private YouTubePlayerView playerView; 
	private YouTubePlayer playa;   //hollla
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.youtube_activity);
		
		playButton = (ImageButton)findViewById(R.id.play_button);
		playButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pauseButton.setVisibility(View.VISIBLE);
				playButton.setVisibility(View.INVISIBLE);
				playa.play();
			}
		});
		pauseButton = (ImageButton)findViewById(R.id.pause_button);
		pauseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playButton.setVisibility(View.VISIBLE);
				pauseButton.setVisibility(View.INVISIBLE);
				playa.pause();
			}
		});
		
		ep1View = (YouTubeThumbnailView)findViewById(R.id.youtube_view1);
		ep1View.initialize(DeveloperKey.DEVELOPER_KEY, new ThumbnailListener(EP1_ID));
		ep2View = (YouTubeThumbnailView)findViewById(R.id.youtube_view2);
		ep2View.initialize(DeveloperKey.DEVELOPER_KEY, new ThumbnailListener(EP2_ID));
		ep3View = (YouTubeThumbnailView)findViewById(R.id.youtube_view3);
		ep3View.initialize(DeveloperKey.DEVELOPER_KEY, new ThumbnailListener(EP3_ID));
		ep4View = (YouTubeThumbnailView)findViewById(R.id.youtube_view4);
		ep4View.initialize(DeveloperKey.DEVELOPER_KEY, new ThumbnailListener(EP4_ID));
		ep5View = (YouTubeThumbnailView)findViewById(R.id.youtube_view5);
		ep5View.initialize(DeveloperKey.DEVELOPER_KEY, new ThumbnailListener(EP5_ID));
		ep6View = (YouTubeThumbnailView)findViewById(R.id.youtube_view6);
		ep6View.initialize(DeveloperKey.DEVELOPER_KEY, new ThumbnailListener(EP6_ID));
		
		
		playerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
		playerView.initialize(DeveloperKey.DEVELOPER_KEY, this);
		playa = null;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * YouTubePlayerView init listeners
	 */
	@Override
	public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error)
	{
		Toast.makeText(TunisianSong.this,
				"Oh dear, something has gone terribly wrong please try ejecting and re-inserting your diskette", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider,
			YouTubePlayer player, boolean wasRestored) {
		playa = player;
		playa.setPlaybackEventListener(new MHPlaybackEventListener());
		playa.setPlayerStateChangeListener(new MHPlayerStateChangeListener());
		playa.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
	}
	/**
	 * Thumbnail Listener
	 * @author  <- .. -> squint hedgehog
	 *
	 */
	private class ThumbnailListener implements YouTubeThumbnailView.OnInitializedListener{
		
		String videoID;
		
		public ThumbnailListener(String vidId){
			videoID = vidId;
		}

		@Override
		public void onInitializationFailure(YouTubeThumbnailView thumbView,
				YouTubeInitializationResult initResult) {
			
		}

		@Override
		public void onInitializationSuccess(YouTubeThumbnailView thumbView,
				YouTubeThumbnailLoader thumbLoader) {
			thumbLoader.setVideo(videoID);
			thumbView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					playa.cueVideo(videoID);
				}
			});
		}
		
	}
	
	/**
	 * Listener classes
	 * @author Robot King Zed
	 *
	 */
	private class MHPlaybackEventListener implements PlaybackEventListener {

		@Override
		public void onBuffering(boolean arg0) {
			Toast.makeText(TunisianSong.this, "onBuffering video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onPaused() {
			Toast.makeText(TunisianSong.this, "onPaused video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onPlaying() {
			Toast.makeText(TunisianSong.this, "onPlaying video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onSeekTo(int arg0) {
			Toast.makeText(TunisianSong.this, "onSeekTo video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStopped() {
			Toast.makeText(TunisianSong.this, "onStopped video...", Toast.LENGTH_SHORT).show();
		}
	}

	private class MHPlayerStateChangeListener implements PlayerStateChangeListener  {

		@Override
		public void onAdStarted() {
			Toast.makeText(TunisianSong.this, "onAdStarted video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onError(ErrorReason arg0) {
			Toast.makeText(TunisianSong.this, "onError video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onLoaded(String arg0) {
			playa.play();
			pauseButton.setVisibility(View.VISIBLE);
			
		}

		@Override
		public void onLoading() {
			Toast.makeText(TunisianSong.this, "onLoading video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onVideoEnded() {
			Toast.makeText(TunisianSong.this, "onVideoEnded video...", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onVideoStarted() {
			Toast.makeText(TunisianSong.this, "onVideoStarted video...", Toast.LENGTH_SHORT).show();
		}

	}

}
