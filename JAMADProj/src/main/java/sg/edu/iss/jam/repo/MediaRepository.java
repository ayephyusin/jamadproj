package sg.edu.iss.jam.repo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.jam.model.Channel;
import sg.edu.iss.jam.model.Media;
import sg.edu.iss.jam.model.MediaType;

public interface MediaRepository extends JpaRepository<Media, Long> {
	
	@Query("SELECT m FROM Media m JOIN m.playLists pl WHERE pl.playlistID = :playlistID")
	List<Media> findMediaListByPlayListID(@Param("playlistID") Long playlistID);
	
	//Find Media Count by channel 
	@Query("Select count(distinct m) from Media m Join m.channel c where c.channelID =:channelid AND m.mediaType =:mediaType")
	public int CountMediaByChannel(@Param("channelid") long channelid,@Param("mediaType") MediaType video);
	
	public Collection<Media> findBychannel(Channel channel);
	
	//scy
//	@Query("Select m, count(distinct uh.id) from Media m join m.userHistory uh "
//			+ "where m.mediaType=:mediatype "
//			+ "and m.createdOn>=Date(:currentdatelessoneweek) "
//			+ "group by m order by count(distinct uh.id) desc") 
//	public List<Object[]> getTopMediasByUserHistory(Pageable pageable, @Param("mediatype") MediaType mediaType,
//													@Param("currentdatelessoneweek") LocalDate currentdatelessoneweek);
 //select by mediatype	
	@Query("Select m from Media m join m.userHistory uh "
			+ "where m.mediaType=:mediatype "
			+ "group by m order by count(distinct uh.id) desc")
	public List<Media> getMediaByTypeAndCount(@Param("mediatype") MediaType mediaType);
	
	@Query("Select m from Media m join m.userHistory uh "
			+ "where m.mediaType=:mediatype "
//			+"and m.createdOn>=Date(:lesscurrentdate) "
			+"and uh.datetime>=Date(:lesscurrentdate)"
			+ "group by m order by count(distinct uh.id) desc") 
	public List<Media> getMediaByUserHistory(@Param("mediatype") MediaType mediaType,
											 @Param("lesscurrentdate") LocalDate lesscurrentdate);


	
}
