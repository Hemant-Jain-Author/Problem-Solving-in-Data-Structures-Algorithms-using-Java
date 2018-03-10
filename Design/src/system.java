public class system {
	private map<int, int> personIdToMachineIdMap;
	private map<int, Machine> machineIdToMachineMap;

	Machine getMachine(int machineId);

	Person getPerson(int personId) {
		int machienId = personIdToMachienIdMap[personId];
		Machine m = machineIdToMachineMap[machienId];
		return m.getPersonWithId(personId);
	}
}
