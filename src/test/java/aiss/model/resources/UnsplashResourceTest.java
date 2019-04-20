package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.resource.UnplashResource;
import aiss.model.unplash.*;



public class UnsplashResourceTest {

	static User user;
	static String token;
	static UnplashResource ur;
	static UnplashCollection uc;

	
	@BeforeClass
	public static void setUp() throws Exception {
		user.setUsername("carjaralv");
		String title="title";
		token="c320079b37a5c1ac8630aa010826f8bd7526e38406cf22242c53d168e67dcb91";//TODO preguntar en clase
		ur =new UnplashResource(token);
		System.out.print("*******"+ur.getUsername());
		ur.createCollection(title, "");

	}

	@AfterClass
	public static void delete() throws Exception {
		//ur.delete(collection.getId());
	}

	@Test
	public void testGetCollections() throws IOException {
		user.setUsername("carjaralv");
		String title="title";
		token="c320079b37a5c1ac8630aa010826f8bd7526e38406cf22242c53d168e67dcb91";//TODO preguntar en clase
		ur =new UnplashResource(token);
		System.out.print("*******"+ur.getUsername());
		ur.createCollection(title, "");

		List<UnplashCollection> cs = ur.getCollections(); 
		
		assertNotNull("The collection of playlists is null", "l");
		
		// Show result
		System.out.println("Listing collections:");
		int i=1;
		for (UnplashCollection c : cs) {
			System.out.println("Collection " + i++ + " : " + c.getTitle() + " (ID=" + c.getId() + ")");
		}
		
	}

//	@Test
//	public void testGetPlaylist() {
//		Playlist p = plr.getPlaylist(playlist.getId());
//		
//		assertEquals("The id of the playlists do not match", playlist.getId(), p.getId());
//		assertEquals("The name of the playlists do not match", playlist.getName(), p.getName());
//		
//		// Show result
//		System.out.println("Playlist id: " +  p.getId());
//		System.out.println("Playlist name: " +  p.getName());
//
//	}
//
//	@Test
//	public void testAddPlaylist() {
//		String playlistName = "Add playlist test title";
//		String playlistDescription = "Add playlist test description";
//		
//		playlist4 = plr.addPlaylist(new Playlist(playlistName,playlistDescription));
//		
//		assertNotNull("Error when adding the playlist", playlist4);
//		assertEquals("The playlist's name has not been setted correctly", playlistName, playlist4.getName());
//		assertEquals("The playlist's description has not been setted correctly", playlistDescription, playlist4.getDescription());
//	}
//
//	@Test
//	public void testUpdatePlaylist() {
//		String playlistName = "Updated playlist name";
//
//		// Update playlist
//		playlist.setName(playlistName);
//
//		boolean success = plr.updatePlaylist(playlist);
//		
//		assertTrue("Error when updating the playlist", success);
//		
//		Playlist pl  = plr.getPlaylist(playlist.getId());
//		assertEquals("The playlist's name has not been updated correctly", playlistName, pl.getName());
//
//	}
//
//	@Test
//	public void testDeletePlaylist() {
//		boolean success = plr.deletePlaylist(playlist2.getId());
//		assertTrue("Error when deleting the playlist", success);
//		
//		Playlist pl = plr.getPlaylist(playlist2.getId());
//		assertNull("The playlist has not been deleted correctly", pl);
//	}
//
//	@Test
//	public void testAddSong() {
//		boolean success = plr.addSong(playlist3.getId(), song.getId());
//		assertTrue("Error when adding the song", success);
//	}
//
//	@Test
//	public void testRemoveCollection() {
//		boolean success =  plr.removeSong(playlist.getId(), song.getId());
//		assertTrue("Error when removing the song", success);
//	}

}
