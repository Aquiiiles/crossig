export const decideOrder = (
  sortBy: string,
  sortedBy: string,
  sortOrder: string
) => {
  if (sortBy === sortedBy) {
    return sortOrder === "asc" ? "desc" : "asc";
  } else {
    return "desc";
  }
};
