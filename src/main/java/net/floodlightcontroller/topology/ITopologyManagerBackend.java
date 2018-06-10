package net.floodlightcontroller.topology;

import java.util.ArrayList;

import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.OFPort;

import net.floodlightcontroller.routing.IRoutingService.PATH_METRIC;
import net.floodlightcontroller.routing.Path;
import net.floodlightcontroller.routing.PathId;
import org.projectfloodlight.openflow.types.U16;
import org.projectfloodlight.openflow.types.U64;

public interface ITopologyManagerBackend extends ITopologyService {
    public TopologyInstance getCurrentTopologyInstance();
    
    public PATH_METRIC getPathMetric();
    public void setPathMetric(PATH_METRIC metric);
    
    public int getMaxPathsToCompute();
    public void setMaxPathsToCompute(int max);
    
    public boolean forceRecompute();
    
    /**
     * Provides a route between src and dst that allows tunnels. The cookie is provisioned
     * for callers of getRoute to provide additional information to influence the route
     * to be returned, if the underlying routing implementation supports choice among
     * multiple routes.
     * @param src Source switch DPID.
     * @param dst Destination switch DPID.
     * @param cookie cookie (usage determined by implementation; ignored by topology instance now).
     */
    public Path getRoute(DatapathId src, DatapathId dst, U64 cookie);

    /**
     * Provides a route between src and dst, with option to allow or
     *  not allow tunnels in the path.
     * @param src Source switch DPID.
     * @param dst Destination switch DPID.
     * @param cookie cookie (usage determined by implementation; ignored by topology instance now).
     * @param tunnelEnabled boolean option.
     */
    public Path getRoute(DatapathId src, DatapathId dst, U64 cookie, boolean tunnelEnabled);

    /**
     * Provides a route between srcPort on src and dstPort on dst.
     * @param src Source switch DPID.
     * @param srcPort Source port on source switch.
     * @param dst Destination switch DPID.
     * @param dstPort dstPort on Destination switch.
     * @param cookie cookie (usage determined by implementation; ignored by topology instance now).
     */
    public Path getRoute(DatapathId srcId, OFPort srcPort, DatapathId dstId, OFPort dstPort, U64 cookie);

    /**
     * Provides a route between srcPort on src and dstPort on dst.
     * @param src Source switch DPID.
     * @param srcPort Source port on source switch.
     * @param dst Destination switch DPID.
     * @param dstPort dstPort on Destination switch.
     * @param cookie cookie (usage determined by implementation; ignored by topology instance now).
     * @param tunnelEnabled boolean option.
     */
    public Path getRoute(DatapathId srcId, OFPort srcPort, DatapathId dstId, OFPort dstPort, U64 cookie, boolean tunnelEnabled);

    
    public ArrayList<Path> getRoutes(DatapathId longSrcDpid, DatapathId longDstDpid, boolean tunnelEnabled);
    public ArrayList<Path> getRoutes(DatapathId longSrcDpid, DatapathId longDstDpid, boolean tunnelEnabled, int k, boolean isDisjoint,String topo);
}