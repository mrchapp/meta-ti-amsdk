DESCRIPTION = "TI Inter Process Ccommunication (IPC) Mechanisms (for Uni- and Multi- Processor Configurations)"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/ipc/index.html"

SECTION = "devel"
LICENSE = "BSD" 

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc

S = "${WORKDIR}/ipc_${PV}"

SRC_URI = "http://t3500wsk1.am.dhcp.ti.com/~x0019444/da830-evm/ipc_${PV}.zip;name=ipczip"

DEPENDS = "ti-sysbios ti-cgt6x ti-xdctools"

do_install() {
    install -d ${D}${IPC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${IPC_INSTALL_DIR_RECIPE}
}

FILES_ti-ipc-dev = "${libdir}/*"
